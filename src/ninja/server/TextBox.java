
package ninja.server;

import ninja.option.ItemOption;

public class TextBox
{
    protected static void openTextBoxId(final Char _char, final short menuId, final String str, byte type) {
        Util.log("openTextBoxId " + menuId + " str " + str + " type " + type);
        switch (menuId) {
            case -104: {
                if (!_char.isHuman) {
                    Service.ServerMessage(_char, Text.get(0, 310));
                    break;
                }
                Admin.Comand(_char, 4, str);
                break;
            }
            case -103: {
                if (!_char.isHuman) {
                    Service.ServerMessage(_char, Text.get(0, 310));
                    break;
                }
                Admin.Comand(_char, 3, str);
                break;
            }
            case -102: {
                if (!_char.isHuman) {
                    Service.ServerMessage(_char, Text.get(0, 310));
                    break;
                }
                Admin.Comand(_char, 2, str);
                break;
            }
            case -101: {
                if (!_char.isHuman) {
                    Service.ServerMessage(_char, Text.get(0, 310));
                    break;
                }
                Admin.Comand(_char, 1, str);
                break;
            }
            case -100: {
                if (!_char.isHuman) {
                    Service.ServerMessage(_char, Text.get(0, 310));
                    break;
                }
                try {
                    final Player player = Client.getPlayer(str);
                    if (player != null) {
                        Admin.Comand(_char, 0, str);
                    }
                    else {
                        Admin.opMenu(_char);
                    }
                }
                catch (Exception e3) {}
                break;
            }
            case 100: {
                if (!_char.isHuman) {
                    Service.ServerMessage(_char, Text.get(0, 310));
                    break;
                }
                try {
                    if (type == -1) {
                        type = _char.menuType;
                    }
                    final Lucky lucky = Lucky.arrLucky[type];
                    if (lucky != null && !lucky.isLockJoin) {
                        final int money = Integer.parseInt(str);
                        if (money > 0) {
                            lucky.Join(_char.user.player, money);
                        }
                    }
                }
                catch (Exception e3) {
                    Util.log("loi tham gia ->>>>");
                }
                break;
            }
            case 101: {
                if (!_char.isHuman) {
                    Service.ServerMessage(_char, Text.get(0, 310));
                    break;
                }
                try {
                    final Lucky lucky = Lucky.arrLucky[type];
                    if (lucky != null) {
                        Service.AlertLuck(_char.user.player, lucky);
                    }
                }
                catch (Exception e3) {
                    Util.log("loi vong xaoy ->>>>>>>");
                }
                break;
            }
            case 102: {
                if (!_char.isHuman) {
                    Service.ServerMessage(_char, Text.get(0, 310));
                    break;
                }
                _char.menuType = -128;
                Service.openUIMenuNew(_char, new String[] { Text.get(0, 66), Text.get(0, 67) });
                break;
            }
            case 498: {
                if (!_char.isHuman) {
                    Service.ServerMessage(_char, Text.get(0, 310));
                    break;
                }
                if (!str.isEmpty() && _char.tileMap.map.isTestDunMap() && !_char.tileMap.map.testDun.isFinght) {
                    try {
                        final TestDun test = _char.tileMap.map.testDun;
                        final int coin = Integer.parseInt(str);
                        if (coin > 0) {
                            if (coin <= _char.user.player.xu) {
                                if (coin < TestDun.minCoin) {
                                    Service.ServerMessage(_char, String.format(Text.get(0, 307), TestDun.minCoin));
                                }
                                else {
                                    final Char player2 = _char.findCharInMap(test.input_charId);
                                    if (test.coinTotal > 0 && test.coinTotal == coin && test.input_charId != _char.charID && player2 != null && player2.user.player.xu >= coin) {
                                        test.TestDunMessage(Text.get(0, 299));
                                        test.timeLength = (int)(System.currentTimeMillis() / 1000L + TestDun.setTimeChien);
                                        final TileMap tileMap = test.maps[1].getSlotZone(_char);
                                        final Map map = test.maps[0];
                                        if (map != null) {
                                            for (byte j = 0; j < map.tileMaps.length; ++j) {
                                                final TileMap tile = map.tileMaps[j];
                                                if (tile != null) {
                                                    try {
                                                        tile.lock.lock("Bat dau loi dai");
                                                        try {
                                                            for (short k = (short)(tile.aCharInMap.size() - 1); k >= 0; --k) {
                                                                final Char player3 = tile.aCharInMap.get(k);
                                                                if (player3 != null && !player3.isNhanban) {
                                                                    player3.tileMap.EXIT(player3);
                                                                    Char.setEffect(player3, (byte)14, -1, 60000, (short)0, null, (byte)0);
                                                                    player3.cx = tileMap.map.template.goX;
                                                                    if (player3.testDunPhe == 1) {
                                                                        final Char char1 = player3;
                                                                        char1.cx += 400;
                                                                    }
                                                                    player3.cy = tileMap.map.template.goY;
                                                                    tileMap.Join(player3);
                                                                    if (player3.cName.equals(test.black) || player3.cName.equals(test.white)) {
                                                                        if (player3.cName.equals(test.white)) {
                                                                            test.level_white = player3.cLevel;
                                                                        }
                                                                        else if (player3.cName.equals(test.black)) {
                                                                            test.level_black = player3.cLevel;
                                                                        }
                                                                        player3.user.player.upCoin(-test.coinTotal, (byte)1);
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        finally {
                                                            tileMap.lock.unlock();
                                                        }
                                                    }
                                                    catch (InterruptedException e) {
                                                        e.printStackTrace();
                                                    }
                                                }
                                            }
                                        }
                                        if (coin >= 100000) {
                                            Client.alertServer(String.format(Text.get(0, 301), test.white, test.level_white, test.black, test.level_black, coin));
                                        }
                                        test.isFinght = true;
                                    }
                                    else {
                                        test.coinTotal = coin;
                                        test.input_charId = _char.charID;
                                        test.TestDunMessage(String.format(Text.get(0, 294), _char.cName, coin));
                                    }
                                }
                            }
                        }
                    }
                    catch (Exception e3) {
                        Util.log("loi Cuc loi dai ->>>>>>>");
                    }
                    break;
                }
                break;
            }
            case 499: {
                if (!_char.isHuman) {
                    Service.ServerMessage(_char, Text.get(0, 310));
                    break;
                }
                if (str.isEmpty()) {
                    break;
                }
                if (TestDun.maxCreate < TestDun.arrTestDun.size()) {
                    Service.openUISay(_char, (short)0, Text.get(0, 304));
                    break;
                }
                if (_char.delaytestDunCharID > 0) {
                    Service.openUISay(_char, (short)0, Text.get(0, 291));
                    break;
                }
                if (str.equals(_char.cName)) {
                    Service.openUISay(_char, (short)0, Text.get(0, 288));
                    break;
                }
                final TileMap tile2 = _char.tileMap;
                try {
                    tile2.lock.lock("vao loi dai");
                    try {
                        Char player4 = null;
                        for (short i = 0; i < tile2.numPlayer; ++i) {
                            final Char p = tile2.aCharInMap.get(i);
                            if (p != null && p.cName.equals(str)) {
                                player4 = p;
                                break;
                            }
                        }
                        if (player4 != null && player4.charID != _char.charID) {
                            Service.openUISay(_char, (short)0, String.format(Text.get(0, 290), str));
                            Service.testDunInvite(player4, _char.charID);
                            _char.testDunCharID = player4.charID;
                            _char.delaytestDunCharID = 30000;
                        }
                        else {
                            Service.openUISay(_char, (short)0, String.format(Text.get(0, 289), str));
                        }
                    }
                    finally {
                        tile2.lock.unlock();
                    }
                }
                catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
                break;
            }
            case 500: {
                if (!_char.isHuman) {
                    Service.ServerMessage(_char, Text.get(0, 310));
                    break;
                }
                if (!str.isEmpty() && _char.cClanName.isEmpty() && _char.user.luong >= 200000 && _char.cLevel >= 40 && _char.clan == null) {
                    Clan.createClan(_char, (short)0, str.toLowerCase());
                    break;
                }
                break;
            }
            case 501:
            case 502:
            case 503: {
                if (!_char.isHuman) {
                    Service.ServerMessage(_char, Text.get(0, 310));
                    break;
                }
                if (!str.isEmpty()) {
                    try {
                        if (menuId == 501) {
                            DiamondSwap.inputDiamond(_char, Integer.parseInt(str), (byte)0);
                        }
                        if (menuId == 502) {
                            DiamondSwap.inputDiamond(_char, Integer.parseInt(str), (byte)1);
                        }
                        if (menuId == 503) {
                            DiamondSwap.inputDiamond(_char, Integer.parseInt(str), (byte)2);
                        }
                    }
                    catch (Exception e3) {}
                    break;
                }
                break;
            }
            case 504: {
                GiftCode.inputCode(_char, str);
                break;
            }
            case 505:
            case 506:
            case 507:
            case 508: {
                if (!_char.isHuman) {
                    Service.ServerMessage(_char, Text.get(0, 310));
                    break;
                }
                if (GameScr.vEvent != 2) {
                    Service.ServerMessage(_char, Text.get(0, 169));
                    break;
                }
                if (!str.isEmpty()) {
                    try {
                        final short num = Short.parseShort(str);
                        final Player player5 = _char.user.player;
                        if (player5.ItemBagIndexNull() == -1) {
                            GameCanvas.startOKDlg(player5.user.session, Text.get(0, 15));
                        }
                        else if (num > 1000) {
                            Service.openUISay(_char, (short)33, String.format(Text.get(0, 325), 1000));
                        }
                        else if (num > 0) {
                            if (menuId == 505) {
                                if (player5.ItemBagQuantity((short)607) < 5 * num || player5.ItemBagQuantity((short)608) < 2 * num || player5.ItemBagQuantity((short)617) < 1 * num) {
                                    Service.openUISay(_char, (short)33, Text.get(0, 170));
                                }
                                else {
                                    player5.ItemBagAddQuantity(new Item(null, (short)612, num, -1, true, (byte)0, 0));
                                    player5.ItemBagUses((short)607, 5 * num);
                                    player5.ItemBagUses((short)608, 2 * num);
                                    player5.ItemBagUses((short)617, 1 * num);
                                }
                            }
                            else if (menuId == 506) {
                                if (player5.ItemBagQuantity((short)609) < 2 * num || player5.ItemBagQuantity((short)610) < 1 * num) {
                                    Service.openUISay(_char, (short)33, Text.get(0, 170));
                                }
                                else if (player5.xu < 20000 * num) {
                                    Service.openUISay(_char, (short)33, String.format(Text.get(0, 284), 20000 * num));
                                }
                                else {
                                    player5.upCoin(-(20000 * num), (byte)1);
                                    player5.ItemBagAddQuantity(new Item(null, (short)611, num, -1, false, (byte)0, 0));
                                    player5.ItemBagUses((short)609, 2 * num);
                                    player5.ItemBagUses((short)610, 1 * num);
                                }
                            }
                            else if (menuId == 507) {
                                if (player5.ItemBagQuantity((short)806) < 1 * num || player5.ItemBagQuantity((short)807) < 1 * num || player5.ItemBagQuantity((short)808) < 2 * num || player5.ItemBagQuantity((short)809) < 1 * num || player5.ItemBagQuantity((short)810) < 1 * num || player5.ItemBagQuantity((short)811) < 2 * num || player5.ItemBagQuantity((short)812) < 1 * num) {
                                    Service.openUISay(_char, (short)33, Text.get(0, 170));
                                }
                                else if (player5.user.luong < 10 * num) {
                                    Service.openUISay(_char, (short)33, String.format(Text.get(0, 285), 10 * num));
                                }
                                else {
                                    player5.upGold(-(10 * num), (byte)1);
                                    player5.ItemBagAddQuantity(new Item(null, (short)818, num, -1, false, (byte)0, 0));
                                    player5.ItemBagUses((short)806, 1 * num);
                                    player5.ItemBagUses((short)807, 1 * num);
                                    player5.ItemBagUses((short)808, 2 * num);
                                    player5.ItemBagUses((short)809, 1 * num);
                                    player5.ItemBagUses((short)810, 1 * num);
                                    player5.ItemBagUses((short)811, 2 * num);
                                    player5.ItemBagUses((short)812, 1 * num);
                                }
                            }
                            else if (menuId == 508) {
                                if (player5.ItemBagQuantity((short)806) < 1 * num || player5.ItemBagQuantity((short)807) < 1 * num || player5.ItemBagQuantity((short)808) < 2 * num || player5.ItemBagQuantity((short)809) < 1 * num || player5.ItemBagQuantity((short)810) < 1 * num || player5.ItemBagQuantity((short)811) < 2 * num || player5.ItemBagQuantity((short)812) < 1 * num) {
                                    Service.openUISay(_char, (short)33, Text.get(0, 170));
                                }
                                else {
                                    player5.ItemBagAddQuantity(new Item(null, (short)617, num, -1, false, (byte)0, 0));
                                    player5.ItemBagUses((short)806, 1 * num);
                                    player5.ItemBagUses((short)807, 1 * num);
                                    player5.ItemBagUses((short)808, 2 * num);
                                    player5.ItemBagUses((short)809, 1 * num);
                                    player5.ItemBagUses((short)810, 1 * num);
                                    player5.ItemBagUses((short)811, 2 * num);
                                    player5.ItemBagUses((short)812, 1 * num);
                                }
                            }
                        }
                    }
                    catch (Exception e3) {
                        Util.log("Input Error number");
                    }
                    break;
                }
                break;
            }
            case 509:
            case 510:
            case 511: {
                if (!_char.isHuman) {
                    Service.ServerMessage(_char, Text.get(0, 310));
                    break;
                }
                if (GameScr.vEvent != 3) {
                    Service.ServerMessage(_char, Text.get(0, 169));
                    break;
                }
                if (!str.isEmpty()) {
                    try {
                        final short num = Short.parseShort(str);
                        final Player player5 = _char.user.player;
                        if (player5.ItemBagIndexNull() == -1) {
                            GameCanvas.startOKDlg(player5.user.session, Text.get(0, 15));
                        }
                        else if (num > 1000) {
                            Service.openUISay(_char, (short)33, String.format(Text.get(0, 325), 1000));
                        }
                        else if (num > 0) {
                            if (menuId == 509) {
                                if (player5.ItemBagQuantity((short)666) < 5 * num || player5.ItemBagQuantity((short)667) < 5 * num || player5.ItemBagQuantity((short)668) < 5 * num || player5.ItemBagQuantity((short)669) < num) {
                                    Service.openUISay(_char, (short)33, Text.get(0, 170));
                                }
                                else {
                                    player5.ItemBagAddQuantity(new Item(null, (short)671, num, -1, false, (byte)0, 0));
                                    player5.ItemBagUses((short)666, 5 * num);
                                    player5.ItemBagUses((short)667, 5 * num);
                                    player5.ItemBagUses((short)668, 5 * num);
                                    player5.ItemBagUses((short)669, num);
                                }
                            }
                            else if (menuId == 510) {
                                if (player5.ItemBagQuantity((short)666) < 5 * num || player5.ItemBagQuantity((short)667) < 5 * num || player5.ItemBagQuantity((short)668) < 5 * num || player5.ItemBagQuantity((short)670) < 2 * num) {
                                    Service.openUISay(_char, (short)33, Text.get(0, 170));
                                }
                                else {
                                    player5.ItemBagAddQuantity(new Item(null, (short)672, num, -1, false, (byte)0, 0));
                                    player5.ItemBagUses((short)666, 5 * num);
                                    player5.ItemBagUses((short)667, 5 * num);
                                    player5.ItemBagUses((short)668, 5 * num);
                                    player5.ItemBagUses((short)670, 2 * num);
                                }
                            }
                            else if (menuId == 511) {
                                if (player5.ItemBagQuantity((short)481) < 3 * num || player5.ItemBagQuantity((short)482) < 3 * num || player5.ItemBagQuantity((short)829) < 3 * num) {
                                    Service.openUISay(_char, (short)33, Text.get(0, 170));
                                }
                                else if (player5.user.luong < 15 * num) {
                                    Service.openUISay(_char, (short)33, String.format(Text.get(0, 285), 15 * num));
                                }
                                else {
                                    player5.ItemBagAddQuantity(new Item(null, (short)828, num, -1, false, (byte)0, 0));
                                    player5.ItemBagUses((short)481, 3 * num);
                                    player5.ItemBagUses((short)482, 3 * num);
                                    player5.ItemBagUses((short)829, 3 * num);
                                    player5.upGold(-(15 * num), (byte)1);
                                }
                            }
                        }
                    }
                    catch (Exception e3) {
                        Util.log("Input Error number");
                    }
                    break;
                }
                break;
            }
            case 512:
            case 513: {
                if (!_char.isHuman) {
                    Service.ServerMessage(_char, Text.get(0, 310));
                    break;
                }
                if (GameScr.vEvent != 4) {
                    Service.ServerMessage(_char, Text.get(0, 169));
                    break;
                }
                if (!str.isEmpty()) {
                    try {
                        final short num = Short.parseShort(str);
                        final Player player5 = _char.user.player;
                        if (player5.ItemBagIndexNull() == -1) {
                            GameCanvas.startOKDlg(player5.user.session, Text.get(0, 15));
                        }
                        else if (num > 1000) {
                            Service.openUISay(_char, (short)33, String.format(Text.get(0, 325), 1000));
                        }
                        else if (num > 0) {
                            if (menuId == 512) {
                                if (player5.ItemBagQuantity((short)638) < 5 * num || player5.ItemBagQuantity((short)639) < 5 * num || player5.ItemBagQuantity((short)640) < 3 * num || player5.ItemBagQuantity((short)641) < 5 * num || player5.ItemBagQuantity((short)642) < 5 * num) {
                                    Service.openUISay(_char, (short)33, Text.get(0, 170));
                                }
                                else {
                                    player5.ItemBagAddQuantity(new Item(null, (short)643, num, -1, false, (byte)0, 0));
                                    player5.ItemBagUses((short)638, 5 * num);
                                    player5.ItemBagUses((short)639, 5 * num);
                                    player5.ItemBagUses((short)640, 3 * num);
                                    player5.ItemBagUses((short)641, 5 * num);
                                    player5.ItemBagUses((short)642, 5 * num);
                                }
                            }
                            else if (menuId == 513) {
                                if (player5.ItemBagQuantity((short)638) < 2 * num || player5.ItemBagQuantity((short)639) < 2 * num || player5.ItemBagQuantity((short)641) < 2 * num || player5.ItemBagQuantity((short)642) < 2 * num) {
                                    Service.openUISay(_char, (short)33, Text.get(0, 170));
                                }
                                else if (player5.user.player.xu < 50000 * num) {
                                    Service.openUISay(_char, (short)33, String.format(Text.get(0, 284), 50000 * num));
                                }
                                else {
                                    player5.ItemBagAddQuantity(new Item(null, (short)644, num, -1, false, (byte)0, 0));
                                    player5.ItemBagUses((short)638, 2 * num);
                                    player5.ItemBagUses((short)639, 2 * num);
                                    player5.ItemBagUses((short)641, 2 * num);
                                    player5.ItemBagUses((short)642, 2 * num);
                                    player5.upCoin(-(50000 * num), (byte)1);
                                }
                            }
                        }
                    }
                    catch (Exception ex) {}
                    break;
                }
                break;
            }
        }
    }
}
