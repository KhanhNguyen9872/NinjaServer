
package ninja.server;

import ninja.option.ItemOption;

public class Menu
{
    private static final int[] arrLevelGift;
    
    protected static void Menu(final Char _char, final byte npcId, byte menuId, final byte optionId) {
        Util.log("npcId:" + npcId + " menuId:" + menuId + " optionId:" + optionId);
        final Npc npc = TileMap.NPCNear(_char, npcId);
        if (Task.isTaskNPC(_char, npcId) && npc != null) {
            if (_char.ctaskIndex == -1) {
                --menuId;
                if (menuId == -1) {
                    Task.Task(_char, npcId);
                }
            }
            else if (Task.isFinishTask(_char)) {
                --menuId;
                if (menuId == -1) {
                    Task.FinishTask(_char, npcId);
                }
            }
            else if (_char.ctaskId == 1) {
                --menuId;
                if (menuId == -1) {
                    Task.doTask(_char, npcId, menuId, optionId);
                }
            }
            else if (_char.ctaskId == 7) {
                --menuId;
                if (menuId == -1) {
                    Task.doTask(_char, npcId, menuId, optionId);
                }
            }
        }
        if (npc != null) {
            switch (npcId) {
                case 0: {
                    if (_char.menuType == 1 && _char.tileMap.map.isTestDunMap()) {
                        if (menuId == 0) {
                            synchronized (TestDun.LOCK) {
                                for (int i = TestDun.arrTestDun.size() - 1; i >= 0; --i) {
                                    final TestDun test = TestDun.arrTestDun.get(i);
                                    if (test != null && test.testdunID == _char.tileMap.map.testDun.testdunID) {
                                        TestDun.arrTestDun.remove(i);
                                        test.CLOSE();
                                    }
                                }
                            }
                            break;
                        }
                        if (menuId == 1) {
                            Service.openTextBoxUI(_char, Text.get(0, 298), (short)498);
                            break;
                        }
                        if (menuId == 2) {
                            break;
                        }
                        break;
                    }
                    else {
                        if (menuId == 0) {
                            Service.openUI(_char, (byte)2, null, null);
                            break;
                        }
                        if (menuId == 1) {
                            if (!_char.isHuman) {
                                Service.ServerMessage(_char, Text.get(0, 310));
                                break;
                            }
                            if (optionId == 0) {
                                if (!_char.cClanName.isEmpty() || _char.clan != null) {
                                    Service.openUISay(_char, npcId, Text.get(0, 187));
                                    break;
                                }
                                if (_char.user.luong < 200000) {
                                    Service.openUISay(_char, npcId, String.format(Text.get(0, 188), 200000));
                                    break;
                                }
                                if (_char.cLevel < 40) {
                                    Service.openUISay(_char, npcId, String.format(Text.get(0, 189), 40));
                                    break;
                                }
                                Service.openTextBoxUI(_char, Text.get(0, 190), (short)500);
                                break;
                            }
                            else {
                                if (optionId != 1) {
                                    break;
                                }
                                if (_char.clan.manor == null && _char.clan.openDun <= 0) {
                                    Service.openUISay(_char, npcId, Text.get(0, 250));
                                    break;
                                }
                                final Clan clan = _char.clan;
                                synchronized (clan.LOCK_CLAN) {
                                    if (clan.manor == null && clan.openDun > 0) {
                                        ClanManor.createManor(_char, clan);
                                    }
                                    else if (clan.manor != null) {
                                        final Map map = ClanManor.getMap(clan.manor, (short)80);
                                        final TileMap tile = map.getSlotZone(_char);
                                        if (tile == null) {
                                            GameCanvas.startOKDlg(_char.user.session, Text.get(0, 24));
                                        }
                                        else {
                                            _char.tileMap.Exit(_char);
                                            _char.cx = tile.map.template.goX;
                                            _char.cy = tile.map.template.goY;
                                            tile.Join(_char);
                                        }
                                    }
                                }
                                break;
                            }
                        }
                        else if (menuId == 2) {
                            if (!_char.isHuman) {
                                Service.ServerMessage(_char, Text.get(0, 310));
                                break;
                            }
                            if (optionId == 0) {
                                Service.reviewPB(_char);
                                break;
                            }
                            if (optionId == 1) {
                                BackCave.JoinCave(_char, (byte)0, npcId);
                                break;
                            }
                            if (optionId == 2) {
                                BackCave.JoinCave(_char, (byte)1, npcId);
                                break;
                            }
                            if (optionId == 3) {
                                BackCave.JoinCave(_char, (byte)2, npcId);
                                break;
                            }
                            if (optionId == 4) {
                                BackCave.JoinCave(_char, (byte)3, npcId);
                                break;
                            }
                            if (optionId == 5) {
                                BackCave.JoinCave(_char, (byte)4, npcId);
                                break;
                            }
                            if (optionId == 6) {
                                BackCave.JoinCave(_char, (byte)5, npcId);
                                break;
                            }
                            break;
                        }
                        else {
                            if (menuId != 3) {
                                break;
                            }
                            if (!_char.isHuman) {
                                Service.ServerMessage(_char, Text.get(0, 310));
                                break;
                            }
                            if (optionId == 0) {
                                Service.openTextBoxUI(_char, Text.get(0, 293), (short)499);
                                break;
                            }
                            if (optionId == 1) {
                                Service.testDunList(_char, TestDun.arrTestDun);
                                break;
                            }
                            break;
                        }
                    }
                    //break;
                }
                case 1: {
                    if (menuId != 0) {
                        break;
                    }
                    if (optionId == 0) {
                        Service.openUI(_char, (byte)(21 - _char.cgender), null, null);
                        break;
                    }
                    if (optionId == 1) {
                        Service.openUI(_char, (byte)(23 - _char.cgender), null, null);
                        break;
                    }
                    if (optionId == 2) {
                        Service.openUI(_char, (byte)(25 - _char.cgender), null, null);
                        break;
                    }
                    if (optionId == 3) {
                        Service.openUI(_char, (byte)(27 - _char.cgender), null, null);
                        break;
                    }
                    if (optionId == 4) {
                        Service.openUI(_char, (byte)(29 - _char.cgender), null, null);
                        break;
                    }
                    break;
                }
                case 2: {
                    if (menuId == 0) {
                        if (optionId == 0) {
                            Service.openUI(_char, (byte)16, null, null);
                            break;
                        }
                        if (optionId == 1) {
                            Service.openUI(_char, (byte)17, null, null);
                            break;
                        }
                        if (optionId == 2) {
                            Service.openUI(_char, (byte)18, null, null);
                            break;
                        }
                        if (optionId == 3) {
                            Service.openUI(_char, (byte)19, null, null);
                            break;
                        }
                        break;
                    }
                    else {
                        if (menuId == 1) {
                            DanhVong.doNVDV(_char, npcId, optionId);
                            break;
                        }
                        break;
                    }
                    //break;
                }
                case 3: {
                    if (menuId == 0) {
                        Service.openUI(_char, (byte)7, null, null);
                        break;
                    }
                    if (menuId == 1) {
                        Service.openUI(_char, (byte)6, null, null);
                        break;
                    }
                    if (menuId != 2) {
                        break;
                    }
                    if (_char.ctaskId == 0 && _char.ctaskIndex == 0) {
                        _char.uptaskMaint();
                        Service.openUISay(_char, npcId, Talk.getTask(0, 1));
                        break;
                    }
                    Service.openUISay(_char, npcId, Talk.get(0, npcId));
                    break;
                }
                case 4: {
                    if (menuId == 0) {
                        Service.openUI(_char, (byte)9, null, null);
                        break;
                    }
                    if (menuId == 1) {
                        Service.openUI(_char, (byte)8, null, null);
                        break;
                    }
                    if (menuId != 2) {
                        break;
                    }
                    if (_char.ctaskId == 0 && _char.ctaskIndex == 1) {
                        _char.uptaskMaint();
                        Service.openUISay(_char, npcId, Talk.getTask(0, 2));
                        break;
                    }
                    Service.openUISay(_char, npcId, Talk.get(0, npcId));
                    break;
                }
                case 5: {
                    if (menuId == 0) {
                        Service.openUI(_char, (byte)4, null, null);
                        break;
                    }
                    if (menuId == 1) {
                        if (!_char.isHuman) {
                            Service.ServerMessage(_char, Text.get(0, 310));
                            break;
                        }
                        _char.mapLTDId = _char.tileMap.mapID;
                        Service.openUISay(_char, npcId, Text.get(0, 39));
                        break;
                    }
                    else if (menuId == 2) {
                        if (!_char.isHuman) {
                            Service.ServerMessage(_char, Text.get(0, 310));
                            break;
                        }
                        if (optionId == 0) {
                            if (_char.cLevel < 60) {
                                Service.ServerMessage(_char, Text.get(0, 127));
                                break;
                            }
                            final Map map2 = MapServer.getMapServer(139);
                            if (map2 != null) {
                                final TileMap tileMap = map2.getSlotZone(_char);
                                if (tileMap == null) {
                                    GameCanvas.startOKDlg(_char.user.session, Text.get(0, 9));
                                }
                                else {
                                    _char.tileMap.Exit(_char);
                                    _char.cx = tileMap.map.template.goX;
                                    _char.cy = tileMap.map.template.goY;
                                    tileMap.Join(_char);
                                }
                            }
                            break;
                        }
                        else {
                            if (optionId == 1) {
                                Service.openUISay(_char, npcId, Text.get(0, 126));
                                break;
                            }
                            break;
                        }
                    }
                    else {
                        if (menuId != 3) {
                            break;
                        }
                        if (_char.ctaskId == 0 && _char.ctaskIndex == 4) {
                            _char.uptaskMaint();
                            Service.openUISay(_char, npcId, Talk.getTask(0, 5));
                            break;
                        }
                        Service.openUISay(_char, npcId, Talk.get(0, npcId));
                        break;
                    }
                    //break;
                }
                case 6: {
                    if (menuId == 0) {
                        if (optionId == 0) {
                            Service.openUI(_char, (byte)10, null, null);
                            break;
                        }
                        if (optionId == 1) {
                            Service.openUI(_char, (byte)31, null, null);
                            break;
                        }
                        if (optionId == 2) {
                            Service.openUISay(_char, npcId, Text.get(0, 76));
                            break;
                        }
                        break;
                    }
                    else if (menuId == 1) {
                        if (optionId == 0) {
                            Service.openUI(_char, (byte)12, null, null);
                            break;
                        }
                        if (optionId == 1) {
                            Service.openUI(_char, (byte)11, null, null);
                            break;
                        }
                        break;
                    }
                    else {
                        if (menuId == 2) {
                            Service.openUI(_char, (byte)13, null, null);
                            break;
                        }
                        if (menuId == 3) {
                            Service.openUI(_char, (byte)33, null, null);
                            break;
                        }
                        if (menuId == 4) {
                            Service.openUI(_char, (byte)46, null, null);
                            break;
                        }
                        if (menuId == 5) {
                            Service.openUI(_char, (byte)47, null, null);
                            break;
                        }
                        if (menuId == 6) {
                            Service.openUI(_char, (byte)49, null, null);
                            break;
                        }
                        if (menuId == 7) {
                            Service.openUI(_char, (byte)50, null, null);
                            break;
                        }
                        if (menuId != 8) {
                            break;
                        }
                        if (_char.ctaskId == 0 && _char.ctaskIndex == 2) {
                            _char.uptaskMaint();
                            Service.openUISay(_char, npcId, Talk.getTask(0, 3));
                            break;
                        }
                        Service.openUISay(_char, npcId, Talk.get(0, npcId));
                        break;
                    }
                    //break;
                }
                case 7: {
                    if (menuId == 0) {
                        if (_char.ctaskId == 0 && _char.ctaskIndex == 5) {
                            _char.uptaskMaint();
                            Service.openUISay(_char, npcId, Talk.getTask(0, 6));
                            break;
                        }
                        Service.openUISay(_char, npcId, Talk.get(0, npcId));
                        break;
                    }
                    else {
                        if (menuId > 0 && menuId <= Map.arrLang.length) {
                            final Map map2 = MapServer.getMapServer(Map.arrLang[menuId - 1]);
                            if (map2 != null) {
                                final TileMap tileMap = map2.getSlotZone(_char);
                                if (tileMap == null) {
                                    GameCanvas.startOKDlg(_char.user.session, Text.get(0, 9));
                                }
                                else if (Task.isLockChangeMap2(tileMap.mapID, _char.ctaskId)) {
                                    GameCanvas.startOKDlg(_char.user.session, Text.get(0, 84));
                                }
                                else {
                                    _char.tileMap.Exit(_char);
                                    _char.cx = tileMap.map.template.goX;
                                    _char.cy = tileMap.map.template.goY;
                                    tileMap.Join(_char);
                                }
                            }
                            break;
                        }
                        break;
                    }
                    //break;
                }
                case 8: {
                    if (menuId >= 0 && menuId < Map.arrTruong.length) {
                        final Map map2 = MapServer.getMapServer(Map.arrTruong[menuId]);
                        if (map2 != null) {
                            final TileMap tileMap = map2.getSlotZone(_char);
                            if (tileMap == null) {
                                GameCanvas.startOKDlg(_char.user.session, Text.get(0, 9));
                            }
                            else if (Task.isLockChangeMap2(tileMap.mapID, _char.ctaskId)) {
                                GameCanvas.startOKDlg(_char.user.session, Text.get(0, 84));
                            }
                            else {
                                _char.tileMap.Exit(_char);
                                _char.cx = tileMap.map.template.goX;
                                _char.cy = tileMap.map.template.goY;
                                tileMap.Join(_char);
                            }
                        }
                        break;
                    }
                    if (menuId != 0) {
                        break;
                    }
                    if (_char.ctaskId == 0 && _char.ctaskIndex == 5) {
                        _char.uptaskMaint();
                        Service.openUISay(_char, npcId, Talk.getTask(0, 6));
                        break;
                    }
                    Service.openUISay(_char, npcId, Talk.get(0, npcId));
                    break;
                }
                case 9: {
                    if (menuId == 0) {
                        if (optionId == 0) {
                            Service.AlertMessage(_char, Text.get(0, 160), Top.getStringBXH(_char, 0));
                            break;
                        }
                        if (optionId == 1) {
                            Service.AlertMessage(_char, Text.get(0, 161), Top.getStringBXH(_char, 1));
                            break;
                        }
                        if (optionId == 2) {
                            Service.AlertMessage(_char, Text.get(0, 162), Top.getStringBXH(_char, 2));
                            break;
                        }
                        if (optionId == 3) {
                            Service.AlertMessage(_char, Text.get(0, 163), Top.getStringBXH(_char, 3));
                            break;
                        }
                        break;
                    }
                    else if (menuId == 1) {
                        if (optionId == 0) {
                            Admission.Admission(_char, npcId, (byte)1);
                            break;
                        }
                        if (optionId == 1) {
                            Admission.Admission(_char, npcId, (byte)2);
                            break;
                        }
                        break;
                    }
                    else {
                        if (menuId == 2) {
                            Char.clearPoint(_char, optionId, npcId);
                            break;
                        }
                        if (menuId == 3) {
                            if (_char.ctaskId == 8 && _char.ctaskIndex == 1) {
                                _char.uptaskMaint();
                                Service.openUISay(_char, npcId, Talk.getTask(0, 112));
                                break;
                            }
                            Service.openUISay(_char, npcId, Talk.get(0, npcId));
                            break;
                        }
                        else {
                            if (menuId == 5) {
                                Service.AlertMessage(_char, Text.get(0, 185), Top.getStringBXH(_char, 4));
                                break;
                            }
                            break;
                        }
                    }
                    //break;
                }
                case 10: {
                    if (menuId == 0) {
                        if (optionId == 0) {
                            Service.AlertMessage(_char, Text.get(0, 160), Top.getStringBXH(_char, 0));
                            break;
                        }
                        if (optionId == 1) {
                            Service.AlertMessage(_char, Text.get(0, 161), Top.getStringBXH(_char, 1));
                            break;
                        }
                        if (optionId == 2) {
                            Service.AlertMessage(_char, Text.get(0, 162), Top.getStringBXH(_char, 2));
                            break;
                        }
                        if (optionId == 3) {
                            Service.AlertMessage(_char, Text.get(0, 163), Top.getStringBXH(_char, 3));
                            break;
                        }
                        break;
                    }
                    else if (menuId == 1) {
                        if (optionId == 0) {
                            Admission.Admission(_char, npcId, (byte)3);
                            break;
                        }
                        if (optionId == 1) {
                            Admission.Admission(_char, npcId, (byte)4);
                            break;
                        }
                        break;
                    }
                    else {
                        if (menuId == 2) {
                            Char.clearPoint(_char, optionId, npcId);
                            break;
                        }
                        if (menuId == 3) {
                            if (_char.ctaskId == 8 && _char.ctaskIndex == 2) {
                                _char.uptaskMaint();
                                Service.openUISay(_char, npcId, Talk.getTask(0, 113));
                                break;
                            }
                            Service.openUISay(_char, npcId, Talk.get(0, npcId));
                            break;
                        }
                        else {
                            if (menuId == 5) {
                                Service.AlertMessage(_char, Text.get(0, 185), Top.getStringBXH(_char, 4));
                                break;
                            }
                            break;
                        }
                    }
                    //break;
                }
                case 11: {
                    if (menuId == 0) {
                        if (optionId == 0) {
                            Service.AlertMessage(_char, Text.get(0, 160), Top.getStringBXH(_char, 0));
                            break;
                        }
                        if (optionId == 1) {
                            Service.AlertMessage(_char, Text.get(0, 161), Top.getStringBXH(_char, 1));
                            break;
                        }
                        if (optionId == 2) {
                            Service.AlertMessage(_char, Text.get(0, 162), Top.getStringBXH(_char, 2));
                            break;
                        }
                        if (optionId == 3) {
                            Service.AlertMessage(_char, Text.get(0, 163), Top.getStringBXH(_char, 3));
                            break;
                        }
                        break;
                    }
                    else if (menuId == 1) {
                        if (optionId == 0) {
                            Admission.Admission(_char, npcId, (byte)5);
                            break;
                        }
                        if (optionId == 1) {
                            Admission.Admission(_char, npcId, (byte)6);
                            break;
                        }
                        break;
                    }
                    else {
                        if (menuId == 2) {
                            Char.clearPoint(_char, optionId, npcId);
                            break;
                        }
                        if (menuId == 3) {
                            if (_char.ctaskId == 8 && _char.ctaskIndex == 3) {
                                _char.uptaskMaint();
                                Service.openUISay(_char, npcId, Talk.getTask(0, 114));
                                break;
                            }
                            Service.openUISay(_char, npcId, Talk.get(0, npcId));
                            break;
                        }
                        else {
                            if (menuId == 5) {
                                Service.AlertMessage(_char, Text.get(0, 185), Top.getStringBXH(_char, 4));
                                break;
                            }
                            break;
                        }
                    }
                    //break;
                }
                case 12: {
                    if (menuId == 1) {
                        Service.openUISay(_char, npcId, Talk.get(0, npcId));
                        break;
                    }
                    if (menuId == 2) {
                        Service.openUISay(_char, npcId, Talk.getTask(0, 34) + Talk.getTask(0, 35) + Talk.getTask(0, 35) + Talk.getTask(0, 35) + Talk.getTask(0, 35));
                        break;
                    }
                    if (menuId == 3) {
                        try {
                            _char.tileMap.lock.lock("Doi phan than");
                            try {
                                Player.toNhanban(_char);
                            }
                            finally {
                                _char.tileMap.lock.unlock();
                            }
                        }
                        catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        break;
                    }
                    if (menuId == 4) {
                        Player player = null;
                        if (!_char.isHuman && _char.user != null) {
                            player = _char.user.player;
                        }
                        try {
                            _char.tileMap.lock.lock("Doi chu than");
                            try {
                                Player.toChar(_char);
                            }
                            finally {
                                _char.tileMap.lock.unlock();
                            }
                        }
                        catch (InterruptedException e2) {
                            e2.printStackTrace();
                        }
                        if (player != null) {
                            Player.CallNhanban(player.tileMap, player);
                        }
                        break;
                    }
                    break;
                }
                case 24: {
                    if (_char.menuType == 1) {
                        if (menuId != 0) {
                            break;
                        }
                        if (_char.ctaskId == 0 && _char.ctaskIndex == 3) {
                            _char.uptaskMaint();
                            Service.openUISay(_char, npcId, Talk.getTask(0, 4));
                            break;
                        }
                        Service.openUISay(_char, npcId, Talk.get(0, npcId));
                        break;
                    }
                    else if (menuId == 0) {
                        if (!_char.isHuman) {
                            Service.ServerMessage(_char, Text.get(0, 310));
                            break;
                        }
                        if (_char.user.luong < 50) {
                            Service.openUISay(_char, npcId, Text.get(0, 154));
                            break;
                        }
                        _char.user.player.upGold(-50L, (byte)1);
                        if (optionId == 0) {
                            _char.user.player.upCoin(500000L, (byte)1);
                            break;
                        }
                        if (optionId == 1) {
                            _char.user.player.upCoinLock(550000L, (byte)1);
                            break;
                        }
                        break;
                    }
                    else {
                        if (menuId == 2) {
                            try {
                                final int level = Menu.arrLevelGift[optionId];
                                if (!_char.isHuman) {
                                    Service.ServerMessage(_char, Text.get(0, 310));
                                }
                                else if (_char.user.player.LevelGift.contains(level)) {
                                    Service.openUISay(_char, npcId, Text.get(0, 164));
                                }
                                else if (level > _char.user.player.cLevel) {
                                    Service.openUISay(_char, npcId, Text.get(0, 165));
                                }
                                else {
                                    switch (level) {
                                        case 10: {
                                            _char.user.player.upCoinLock(10000L, (byte)1);
                                            _char.user.player.upCoinLock(10000000L, (byte)1);
                                            break;
                                        }
                                        case 20: {
                                            if (_char.user.player.ItemBagSlotNull() < 1) {
                                                Service.openUISay(_char, npcId, String.format(Text.get(0, 151), 1));
                                                return;
                                            }
                                            _char.user.player.ItemBagAdd(new Item(null, (short)240, 1, -1, true, (byte)0, 0));
                                            _char.user.player.upGold(10L, (byte)1);
                                            _char.user.player.upCoinLock(20000000L, (byte)1);
                                            break;
                                        }
                                        case 30: {
                                            if (_char.user.player.ItemBagSlotNull() < 2) {
                                                Service.openUISay(_char, npcId, String.format(Text.get(0, 151), 2));
                                                return;
                                            }
                                            _char.user.player.ItemBagAdd(new Item(null, (short)241, 1, -1, true, (byte)0, 0));
                                            _char.user.player.ItemBagAdd(new Item(null, (short)5, 1, -1, true, (byte)0, 0));
                                            _char.user.player.upCoinLock(30000000L, (byte)1);
                                            break;
                                        }
                                        case 40: {
                                            if (_char.user.player.ItemBagSlotNull() < 2) {
                                                Service.openUISay(_char, npcId, String.format(Text.get(0, 151), 2));
                                                return;
                                            }
                                            _char.user.player.ItemBagAdd(new Item(null, (short)242, 1, -1, true, (byte)0, 0));
                                            _char.user.player.ItemBagAdd(new Item(null, (short)6, 1, -1, true, (byte)0, 0));
                                            _char.user.player.upCoinLock(40000000L, (byte)1);
                                            break;
                                        }
                                        case 50: {
                                            if (_char.user.player.ItemBagSlotNull() < 2) {
                                                Service.openUISay(_char, npcId, String.format(Text.get(0, 151), 2));
                                                return;
                                            }
                                            _char.user.player.ItemBagAdd(new Item(null, (short)269, 1, -1, true, (byte)0, 0));
                                            _char.user.player.ItemBagAdd(new Item(null, (short)7, 1, -1, true, (byte)0, 0));
                                            _char.user.player.upCoinLock(50000000L, (byte)1);
                                            break;
                                        }
                                    }
                                    _char.user.player.LevelGift.add(level);
                                }
                            }
                            catch (Exception e3) {}
                            break;
                        }
                        if (menuId == 3) {
                            if (_char.ctaskId == 0 && _char.ctaskIndex == 3) {
                                _char.uptaskMaint();
                                Service.openUISay(_char, npcId, Talk.getTask(0, 4));
                                break;
                            }
                            Service.openUISay(_char, npcId, Talk.get(0, npcId));
                            break;
                        }
                        else {
                            if (menuId != 4) {
                                break;
                            }
                            if (!_char.isHuman) {
                                Service.ServerMessage(_char, Text.get(0, 310));
                                break;
                            }
                            if (optionId == 0) {
                                Service.openTextBoxUI(_char, Text.get(0, 255), (short)501);
                                break;
                            }
                            if (optionId == 1) {
                                Service.openTextBoxUI(_char, Text.get(0, 255), (short)502);
                                break;
                            }
                            if (optionId == 2) {
                                Service.openTextBoxUI(_char, Text.get(0, 255), (short)503);
                                break;
                            }
                            if (optionId == 3) {
                                DiamondSwap.viewDiamond(_char);
                                break;
                            }
                            if (optionId == 4) {
                                DiamondSwap.BangGia(_char);
                                break;
                            }
                            break;
                        }
                    }
                    //break;
                }
                case 25: {
                    if (_char.menuType == 1 && _char.tileMap.map.isChienTruong()) {
                        final ChienTruong ct = ChienTruong.chien_truong;
                        if (menuId == 0) {
                            synchronized (ct.CHIENTRUONG_LOCK) {
                                final Map ltd = MapServer.getMapServer(_char.mapLTDId);
                                if (ltd != null) {
                                    final TileMap tile = ltd.getSlotZone(_char);
                                    if (tile == null) {
                                        GameCanvas.startOKDlg(_char.user.session, Text.get(0, 9));
                                    }
                                    else {
                                        _char.tileMap.Exit(_char);
                                        _char.cx = tile.map.template.goX;
                                        _char.cy = tile.map.template.goY;
                                        tile.Join(_char);
                                    }
                                }
                            }
                        }
                        else if (menuId == 1) {
                            Service.reviewChienTruong(_char, ct);
                        }
                        break;
                    }
                    if (menuId != 2) {
                        break;
                    }
                    if (!_char.isHuman) {
                        Service.ServerMessage(_char, Text.get(0, 310));
                        break;
                    }
                    if (optionId == 0 || optionId == 1) {
                        final ChienTruong ct = ChienTruong.chien_truong;
                        if (ct == null) {
                            Service.openUISay(_char, npcId, Text.get(0, 330));
                        }
                        else {
                            synchronized (ct.CHIENTRUONG_LOCK) {
                                if (!ct.isBaoDanh && !ct.aCharBlack.contains(_char.user.player.playerId) && !ct.aCharWhite.contains(_char.user.player.playerId)) {
                                    Service.openUISay(_char, npcId, Text.get(0, 350));
                                }
                                else if (optionId == 0 && ct.aCharBlack.contains(_char.user.player.playerId)) {
                                    Service.openUISay(_char, npcId, Text.get(0, 351));
                                }
                                else if (optionId == 1 && ct.aCharWhite.contains(_char.user.player.playerId)) {
                                    Service.openUISay(_char, npcId, Text.get(0, 352));
                                }
                                else {
                                    short mapGo = -1;
                                    if (optionId == 0) {
                                        mapGo = 98;
                                        if (!ct.aCharWhite.contains(_char.user.player.playerId)) {
                                            _char.user.player.pointChienTruong = 0;
                                            ct.aCharWhite.add(_char.user.player.playerId);
                                        }
                                    }
                                    else if (optionId == 1) {
                                        mapGo = 104;
                                        if (!ct.aCharBlack.contains(_char.user.player.playerId)) {
                                            _char.user.player.pointChienTruong = 0;
                                            ct.aCharBlack.add(_char.user.player.playerId);
                                        }
                                    }
                                    if (mapGo != -1) {
                                        final Map map3 = ChienTruong.getMap(ct, mapGo);
                                        if (map3 != null) {
                                            final TileMap tileMap2 = map3.getSlotZone(_char);
                                            if (tileMap2 != null) {
                                                _char.tileMap.Exit(_char);
                                                _char.cx = map3.template.goX;
                                                _char.cy = map3.template.goY;
                                                tileMap2.Join(_char);
                                                Top.sortTop(5, _char.cName, ChienTruong.TITLE_CT[_char.getCT()], _char.pointChienTruong, new int[] { (_char.cTypePk == 4) ? 0 : ((_char.cTypePk == 5) ? 1 : -1) });
                                            }
                                            else {
                                                GameCanvas.startOKDlg(_char.user.session, Text.get(0, 9));
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        break;
                    }
                    if (optionId == 2) {
                        final ChienTruong ct = ChienTruong.chien_truong;
                        if (ct == null) {
                            Service.openUISay(_char, npcId, Text.get(0, 330));
                        }
                        else {
                            Service.reviewChienTruong(_char, ct);
                        }
                        break;
                    }
                    break;
                }
                case 26: {
                    if (menuId == 0) {
                        Service.openUI(_char, (byte)14, null, null);
                        break;
                    }
                    if (menuId == 1) {
                        Service.openUI(_char, (byte)15, null, null);
                        break;
                    }
                    if (menuId == 2) {
                        Service.openUI(_char, (byte)32, null, null);
                        break;
                    }
                    if (menuId == 3) {
                        Service.openUI(_char, (byte)34, null, null);
                        break;
                    }
                    break;
                }
                case 28: {
                    if (menuId == 0) {
                        if (optionId == 0) {
                            Service.loadItemAuction(_char, optionId, ItemStands.arrItemStands[0]);
                            break;
                        }
                        if (optionId == 1) {
                            Service.loadItemAuction(_char, optionId, ItemStands.arrItemStands[1]);
                            break;
                        }
                        if (optionId == 2) {
                            Service.loadItemAuction(_char, optionId, ItemStands.arrItemStands[2]);
                            break;
                        }
                        if (optionId == 3) {
                            Service.loadItemAuction(_char, optionId, ItemStands.arrItemStands[3]);
                            break;
                        }
                        if (optionId == 4) {
                            Service.loadItemAuction(_char, optionId, ItemStands.arrItemStands[4]);
                            break;
                        }
                        if (optionId == 5) {
                            Service.loadItemAuction(_char, optionId, ItemStands.arrItemStands[5]);
                            break;
                        }
                        if (optionId == 6) {
                            Service.loadItemAuction(_char, optionId, ItemStands.arrItemStands[6]);
                            break;
                        }
                        if (optionId == 7) {
                            Service.loadItemAuction(_char, optionId, ItemStands.arrItemStands[7]);
                            break;
                        }
                        if (optionId == 8) {
                            Service.loadItemAuction(_char, optionId, ItemStands.arrItemStands[8]);
                            break;
                        }
                        if (optionId == 9) {
                            Service.loadItemAuction(_char, optionId, ItemStands.arrItemStands[9]);
                            break;
                        }
                        if (optionId == 10) {
                            Service.loadItemAuction(_char, optionId, ItemStands.arrItemStands[10]);
                            break;
                        }
                        if (optionId == 11) {
                            Service.loadItemAuction(_char, optionId, ItemStands.arrItemStands[11]);
                            break;
                        }
                        break;
                    }
                    else {
                        if (menuId != 1) {
                            break;
                        }
                        if (!_char.isHuman) {
                            Service.ServerMessage(_char, Text.get(0, 310));
                            break;
                        }
                        Service.openUI(_char, (byte)36, null, null);
                        break;
                    }
                    //break;
                }
                case 29: {
                    if (menuId != 0) {
                        break;
                    }
                    if (optionId == 0) {
                        BiKip.LuyenBiKip(_char);
                        break;
                    }
                    if (optionId == 1) {
                        final Item it = _char.ItemBody[15];
                        if (it == null) {
                            Service.ServerMessage(_char, Text.get(0, 389));
                        }
                        else if (it.upgrade >= 10) {
                            Service.ServerMessage(_char, Text.get(0, 390));
                        }
                        else {
                            Service.openUIConfirmID(_char, String.format(Text.get(0, 388), it.template.name, BiKip.goldUps[it.upgrade], BiKip.SL_NL[it.upgrade], GameScr.itemTemplates[457].name, BiKip.percents[it.upgrade], "%"), (byte)(-125));
                        }
                        break;
                    }
                    if (optionId == 2) {
                        Service.AlertMessage(_char, Text.get(0, 130), Text.get(0, 385));
                        break;
                    }
                    break;
                }
                case 30: {
                    if (menuId == 0) {
                        Service.openUI(_char, (byte)38, null, null);
                        break;
                    }
                    if (menuId == 1) {
                        Service.openTextBoxUI(_char, Text.get(0, 51), (short)504);
                        break;
                    }
                    if (menuId == 2) {
                        if (!_char.isHuman) {
                            Service.ServerMessage(_char, Text.get(0, 310));
                            break;
                        }
                        if (optionId == 0) {
                            final Lucky lucky = Lucky.arrLucky[0];
                            Service.AlertLuck(_char.user.player, lucky);
                        }
                        else if (optionId == 1) {
                            Service.openTextBoxUI(_char, Text.get(0, 66), (short)100);
                        }
                        else if (optionId == 2) {
                            Service.AlertMessage(_char, Text.get(0, 66), Text.get(0, 69));
                        }
                        _char.menuType = 0;
                        break;
                    }
                    else {
                        if (menuId != 3) {
                            break;
                        }
                        if (!_char.isHuman) {
                            Service.ServerMessage(_char, Text.get(0, 310));
                            break;
                        }
                        if (optionId == 0) {
                            final Lucky lucky = Lucky.arrLucky[1];
                            Service.AlertLuck(_char.user.player, lucky);
                        }
                        else if (optionId == 1) {
                            Service.openTextBoxUI(_char, Text.get(0, 67), (short)100);
                        }
                        else if (optionId == 2) {
                            Service.AlertMessage(_char, Text.get(0, 66), Text.get(0, 70));
                        }
                        _char.menuType = 1;
                        break;
                    }
                    //break;
                }
                case 31: {
                    if (menuId != 0) {
                        break;
                    }
                    if (!_char.isHuman) {
                        Service.ServerMessage(_char, Text.get(0, 310));
                        break;
                    }
                    if (GameScr.vEvent != 1 || npc.type == 15) {
                        break;
                    }
                    if (_char.user.player.ItemBagQuantity((short)310) < 1) {
                        Service.ServerMessage(_char, Text.get(0, 174));
                        break;
                    }
                    Event.Lighting(_char, npc);
                    break;
                }
                case 32: {
                    if (menuId == 0) {
                        break;
                    }
                    if (menuId != 4) {
                        break;
                    }
                    if (optionId == 0) {
                        Service.openUI(_char, (byte)43, null, null);
                        break;
                    }
                    if (optionId == 1) {
                        Service.openUI(_char, (byte)44, null, null);
                        break;
                    }
                    if (optionId == 2) {
                        Service.openUI(_char, (byte)45, null, null);
                        break;
                    }
                    if (optionId == 3) {
                        Service.AlertMessage(_char, Text.get(0, 130), Text.get(0, 131));
                        break;
                    }
                    break;
                }
                case 33: {
                    if (!_char.isHuman) {
                        Service.ServerMessage(_char, Text.get(0, 310));
                        break;
                    }
                    Event.doEventMenu(_char, menuId, optionId, npcId);
                    break;
                }
                case 34: {
                    if (GameScr.vEvent == 3) {
                        Event.cayThong(_char, menuId, optionId, npcId);
                    }
                    if (GameScr.vEvent == 4) {
                        Event.hoaDao(_char, menuId, optionId, npcId);
                        break;
                    }
                    break;
                }
            }
        }
    }
    
    protected static void MenuNew(final Char _char, final byte npcId, final byte menuId, final byte optionId) {
        switch (_char.menuType + 128) {
            case 0: {
                if (menuId == 0) {
                    _char.menuType = -127;
                    Service.openUIMenuNew(_char, new String[] { Text.get(0, 71), Text.get(0, 72) });
                    break;
                }
                if (menuId == 1) {
                    _char.menuType = -126;
                    Service.openUIMenuNew(_char, new String[] { Text.get(0, 71), Text.get(0, 72) });
                    break;
                }
                break;
            }
            case 1: {
                if (menuId == 0) {
                    final Lucky lucky = Lucky.arrLucky[0];
                    Service.AlertLuck(_char.user.player, lucky);
                    break;
                }
                if (menuId == 1) {
                    Service.AlertMessage(_char, Text.get(0, 66), Text.get(0, 69));
                    break;
                }
                break;
            }
            case 2: {
                if (menuId == 0) {
                    final Lucky lucky = Lucky.arrLucky[1];
                    Service.AlertLuck(_char.user.player, lucky);
                    break;
                }
                if (menuId == 1) {
                    Service.AlertMessage(_char, Text.get(0, 66), Text.get(0, 70));
                    break;
                }
                break;
            }
            case 3: {
                Admin.controller(_char, menuId);
                break;
            }
        }
    }
    
    protected static void openMenu(final Char _char, final short npcTemplateId) {
        String[] Arrcaption = null;
        _char.menuType = 0;
        if (Task.isTaskNPC(_char, npcTemplateId)) {
            Arrcaption = new String[] { null };
            if (_char.ctaskIndex == -1) {
                Arrcaption[0] = GameScr.taskTemplates[_char.ctaskId].name;
            }
            else if (Task.isFinishTask(_char)) {
                Arrcaption[0] = Text.get(0, 12);
            }
            else if (_char.ctaskIndex >= 0 && _char.ctaskIndex <= 4 && _char.ctaskId == 1) {
                Arrcaption[0] = GameScr.taskTemplates[_char.ctaskId].name;
            }
            else if (_char.ctaskIndex >= 1 && _char.ctaskIndex <= 15 && _char.ctaskId == 7) {
                Arrcaption[0] = GameScr.taskTemplates[_char.ctaskId].name;
            }
        }
        if (_char.tileMap != null && _char.tileMap.map.isTestDunMap() && npcTemplateId == 0 && !_char.tileMap.map.testDun.isFinght) {
            _char.menuType = 1;
            Service.openUIMenuNew(_char, new String[] { Text.get(0, 295), Text.get(0, 296), Text.get(0, 297) });
        }
        else if (_char.tileMap != null && _char.tileMap.map.isChienTruong() && npcTemplateId == 25) {
            _char.menuType = 1;
            Service.openUIMenuNew(_char, new String[] { Text.get(0, 295), Text.get(0, 335) });
        }
        else if (_char.tileMap != null && _char.tileMap.mapID == 22 && npcTemplateId == 24) {
            _char.menuType = 1;
            Service.openUIMenuNew(_char, new String[] { Text.get(0, 155) });
        }
        else {
            Service.openUIMenu(_char, Arrcaption);
        }
    }
    
    static {
        arrLevelGift = new int[] { 10, 20, 30, 40, 50 };
    }
}
