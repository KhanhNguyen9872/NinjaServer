package ninja.server;

import ninja.option.ItemOption;

public class Confirm
{
    protected static void openConfirmID(final Char _char, final byte id) {
        switch (id) {
            case Byte.MIN_VALUE: {
                if (_char.nvDV[4] != -1 && _char.cLevel >= 50 && _char.isHuman) {
                    Service.AlertMessage(_char, Text.get(0, 363), String.format(Text.get(0, 364), DanhVong.TILE_NV[_char.nvDV[1]]));
                    DanhVong.clearNV(_char);
                    break;
                }
                break;
            }
            case -127:
            case -126: {
                final Item item = _char.ItemBody[14];
                if (item == null || item.upgrade >= 10) {
                    break;
                }
                if (_char.user.player.ItemBoxSlotNull() < 1) {
                    Service.ServerMessage(_char, String.format(Text.get(0, 371), 1));
                    break;
                }
                final int pointMax = DanhVong.POINT_DV[item.upgrade];
                final int coin = DanhVong.COIN[item.upgrade];
                int gold = 0;
                int percent = DanhVong.PERCENT[item.upgrade];
                if (id == -126) {
                    gold = DanhVong.GOLD[item.upgrade];
                    percent *= 2;
                }
                if ((coin <= _char.user.player.xu || coin <= _char.user.player.yen) && gold <= _char.user.luong) {
                    if (_char.pointNon < pointMax || _char.pointVukhi < pointMax || _char.pointAo < pointMax || _char.pointLien < pointMax || _char.pointGangtay < pointMax || _char.pointNhan < pointMax || _char.pointQuan < pointMax || _char.pointNgocboi < pointMax || _char.pointGiay < pointMax || _char.pointPhu < pointMax) {
                        for (byte i = 0; i < 10; ++i) {
                            if (DanhVong.getPoint(_char, i) < pointMax) {
                                Service.ServerMessage(_char, String.format(Text.get(0, 354), pointMax, DanhVong.TILE_TYPE[i]));
                                return;
                            }
                        }
                    }
                    else if (_char.user.player.ItemBagQuantity(DanhVong.DA_DV[item.upgrade]) < 10) {
                        Service.ServerMessage(_char, String.format(Text.get(0, 375), 10, DanhVong.DA_DV[item.upgrade]));
                    }
                    else {
                        if (coin <= _char.user.player.yen) {
                            _char.user.player.upCoinLock(-coin, (byte)0);
                        }
                        else {
                            _char.user.player.upCoin(-coin, (byte)0);
                        }
                        _char.user.player.upGold(-gold, (byte)0);
                        _char.user.player.ItemBagUses(DanhVong.DA_DV[item.upgrade], 10);
                        if (Util.nextInt(1, Util.nextInt(70, 100)) <= percent) {
                            _char.ItemBody[14] = null;
                            final byte upgrade = (byte)(item.upgrade + 1);
                            Service.MELoadALL(_char);
                            Player.updateInfoPlayer(_char);
                            final Item itnew = new Item(ItemOption.arrOptionDefault(DanhVong.GAN[upgrade], (byte)0), DanhVong.GAN[upgrade], 1, -1, true, (byte)0, 5);
                            itnew.upgrade = upgrade;
                            _char.user.player.ItemBagAdd(itnew);
                            Service.ServerMessage(_char, Text.get(0, 374));
                        }
                        else {
                            Service.ServerMessage(_char, Text.get(0, 373));
                        }
                    }
                }
                else {
                    Service.ServerMessage(_char, Text.get(0, 372));
                }
                break;
            }
            case -125: {
                BiKip.NangCap(_char);
                break;
            }
        }
    }
}
