
package ninja.server;

import ninja.option.ItemOption;

public class Task
{
    protected static void Task(final Char _char, final short npcTemplateId) {
        switch (_char.ctaskId) {
            case 0: {
                Service.openUIConfirm(_char, npcTemplateId, Talk.getTask(0, 0), new String[] { Text.get(0, 10), Text.get(0, 11) });
                break;
            }
            case 1: {
                Service.openUIConfirm(_char, npcTemplateId, Talk.getTask(0, 7), new String[] { Text.get(0, 10), Text.get(0, 11) });
                break;
            }
            case 2: {
                Service.openUIConfirm(_char, npcTemplateId, Talk.getTask(0, 27), new String[] { Text.get(0, 10), Text.get(0, 11) });
                break;
            }
            case 3: {
                Service.openUIConfirm(_char, npcTemplateId, Talk.getTask(0, 30), new String[] { Text.get(0, 10), Text.get(0, 11) });
                break;
            }
            case 4: {
                Service.openUIConfirm(_char, npcTemplateId, Talk.getTask(0, 35), new String[] { Text.get(0, 10), Text.get(0, 11) });
                break;
            }
            case 5: {
                Service.openUIConfirm(_char, npcTemplateId, Talk.getTask(0, 38), new String[] { Text.get(0, 10), Text.get(0, 11) });
                break;
            }
            case 6: {
                Service.openUIConfirm(_char, npcTemplateId, Talk.getTask(0, 41), new String[] { Text.get(0, 10), Text.get(0, 11) });
                break;
            }
            case 7: {
                Service.openUIConfirm(_char, npcTemplateId, Talk.getTask(0, 44), new String[] { Text.get(0, 10), Text.get(0, 11) });
                break;
            }
            case 8: {
                Service.openUIConfirm(_char, npcTemplateId, Talk.getTask(0, 110), new String[] { Text.get(0, 10), Text.get(0, 11) });
                break;
            }
            case 9: {
                Service.openUIConfirm(_char, npcTemplateId, Talk.getTask(0, 116), new String[] { Text.get(0, 10), Text.get(0, 11) });
                break;
            }
            case 10: {
                Service.openUIConfirm(_char, npcTemplateId, Talk.getTask(0, 118), new String[] { Text.get(0, 10), Text.get(0, 11) });
                break;
            }
            case 11: {
                Service.openUIConfirm(_char, npcTemplateId, Talk.getTask(0, 121), new String[] { Text.get(0, 10), Text.get(0, 11) });
                break;
            }
        }
    }
    
    protected static void doTask(final Char _char, final short npcTemplateId, final byte menuId, final byte optionId) {
        if (_char.ctaskId == 1) {
            if (_char.ctaskIndex == 0) {
                Service.openUIConfirm(_char, npcTemplateId, Talk.getTask(0, 12), new String[] { Talk.getTask(0, 17), Talk.getTask(0, 18), Talk.getTask(0, 19) });
            }
            else if (_char.ctaskIndex == 1) {
                Service.openUIConfirm(_char, npcTemplateId, Talk.getTask(0, 13), new String[] { Talk.getTask(0, 19), Talk.getTask(0, 20), Talk.getTask(0, 18) });
            }
            else if (_char.ctaskIndex == 2) {
                Service.openUIConfirm(_char, npcTemplateId, Talk.getTask(0, 14), new String[] { Talk.getTask(0, 18), Talk.getTask(0, 17), Talk.getTask(0, 21) });
            }
            else if (_char.ctaskIndex == 3) {
                Service.openUIConfirm(_char, npcTemplateId, Talk.getTask(0, 15), new String[] { Talk.getTask(0, 22), Talk.getTask(0, 18), Talk.getTask(0, 23) });
            }
            else if (_char.ctaskIndex == 4) {
                Service.openUIConfirm(_char, npcTemplateId, Talk.getTask(0, 16), new String[] { Talk.getTask(0, 20), Talk.getTask(0, 23), Talk.getTask(0, 19) });
            }
        }
        else if (_char.ctaskId == 7) {
            if (_char.ctaskIndex == 1) {
                Service.openUIConfirm(_char, npcTemplateId, Talk.getTask(0, 49), new String[] { Talk.getTask(0, 46), Talk.getTask(0, 47), Talk.getTask(0, 48) });
            }
            else if (_char.ctaskIndex == 2) {
                Service.openUIConfirm(_char, npcTemplateId, Talk.getTask(0, 50), new String[] { Talk.getTask(0, 51), Talk.getTask(0, 52), Talk.getTask(0, 53) });
            }
            else if (_char.ctaskIndex == 3) {
                Service.openUIConfirm(_char, npcTemplateId, Talk.getTask(0, 54), new String[] { Talk.getTask(0, 55), Talk.getTask(0, 56), Talk.getTask(0, 57) });
            }
            else if (_char.ctaskIndex == 4) {
                Service.openUIConfirm(_char, npcTemplateId, Talk.getTask(0, 58), new String[] { Talk.getTask(0, 59), Talk.getTask(0, 60), Talk.getTask(0, 61) });
            }
            else if (_char.ctaskIndex == 5) {
                Service.openUIConfirm(_char, npcTemplateId, Talk.getTask(0, 62), new String[] { Talk.getTask(0, 63), Talk.getTask(0, 64), Talk.getTask(0, 65) });
            }
            else if (_char.ctaskIndex == 6) {
                Service.openUIConfirm(_char, npcTemplateId, Talk.getTask(0, 67), new String[] { Talk.getTask(0, 68), Talk.getTask(0, 69), Talk.getTask(0, 70) });
            }
            else if (_char.ctaskIndex == 7) {
                Service.openUIConfirm(_char, npcTemplateId, Talk.getTask(0, 71), new String[] { Talk.getTask(0, 72), Talk.getTask(0, 73), Talk.getTask(0, 74) });
            }
            else if (_char.ctaskIndex == 8) {
                Service.openUIConfirm(_char, npcTemplateId, Talk.getTask(0, 75), new String[] { Talk.getTask(0, 76), Talk.getTask(0, 77), Talk.getTask(0, 78) });
            }
            else if (_char.ctaskIndex == 9) {
                Service.openUIConfirm(_char, npcTemplateId, Talk.getTask(0, 79), new String[] { Talk.getTask(0, 80), Talk.getTask(0, 81), Talk.getTask(0, 82) });
            }
            else if (_char.ctaskIndex == 10) {
                Service.openUIConfirm(_char, npcTemplateId, Talk.getTask(0, 83), new String[] { Talk.getTask(0, 84), Talk.getTask(0, 85), Talk.getTask(0, 86) });
            }
            else if (_char.ctaskIndex == 11) {
                Service.openUIConfirm(_char, npcTemplateId, Talk.getTask(0, 88), new String[] { Talk.getTask(0, 89), Talk.getTask(0, 90), Talk.getTask(0, 91) });
            }
            else if (_char.ctaskIndex == 12) {
                Service.openUIConfirm(_char, npcTemplateId, Talk.getTask(0, 92), new String[] { Talk.getTask(0, 93), Talk.getTask(0, 94), Talk.getTask(0, 95) });
            }
            else if (_char.ctaskIndex == 13) {
                Service.openUIConfirm(_char, npcTemplateId, Talk.getTask(0, 96), new String[] { Talk.getTask(0, 97), Talk.getTask(0, 98), Talk.getTask(0, 99) });
            }
            else if (_char.ctaskIndex == 14) {
                Service.openUIConfirm(_char, npcTemplateId, Talk.getTask(0, 100), new String[] { Talk.getTask(0, 101), Talk.getTask(0, 102), Talk.getTask(0, 103) });
            }
            else if (_char.ctaskIndex == 15) {
                Service.openUIConfirm(_char, npcTemplateId, Talk.getTask(0, 104), new String[] { Talk.getTask(0, 105), Talk.getTask(0, 106), Talk.getTask(0, 107) });
            }
        }
    }
    
    protected static void FinishTask(final Char _char, final short npcTemplateId) {
        switch (_char.ctaskId) {
            case 0: {
                Service.openUISay(_char, npcTemplateId, Talk.getTask(0, 9));
                _char.user.player.upCoinLock(10000L, (byte)1);
                _char.updateExp(200L);
                break;
            }
            case 1: {
                if (_char.user.player.ItemBagSlotNull() < 1) {
                    GameCanvas.startOKDlg(_char.user.session, Text.get(0, 15));
                    return;
                }
                Service.openUISay(_char, npcTemplateId, Talk.getTask(0, 26));
                _char.user.player.upCoinLock(100L, (byte)1);
                _char.updateExp(400L);
                _char.user.player.ItemBagAdd(new Item(new ItemOption[] { new ItemOption(0, Util.nextInt(10, 20)), new ItemOption(8, Util.nextInt(1, 10)) }, (short)194, 1, -1, true, (byte)0, 5));
                break;
            }
            case 2: {
                Service.openUISay(_char, npcTemplateId, Talk.getTask(0, 28));
                _char.user.player.upCoinLock(200L, (byte)1);
                _char.updateExp(800L);
                break;
            }
            case 3: {
                Service.openUISay(_char, npcTemplateId, Talk.getTask(0, 34));
                _char.user.player.upCoinLock(300L, (byte)1);
                _char.updateExp(1500L);
                break;
            }
            case 4: {
                if (_char.user.player.ItemBagSlotNull() < 1) {
                    GameCanvas.startOKDlg(_char.user.session, Text.get(0, 15));
                    return;
                }
                Service.openUISay(_char, npcTemplateId, Talk.getTask(0, 37));
                _char.user.player.upCoinLock(400L, (byte)1);
                _char.updateExp(2000L);
                _char.user.player.ItemBagAdd(new Item(new ItemOption[] { new ItemOption(47, Util.nextInt(0, 1)), new ItemOption(6, Util.nextInt(0, 5)), new ItemOption(7, Util.nextInt(0, 5)) }, (short)(198 - _char.cgender), 1, -1, true, (byte)Util.nextInt(1, 3), 5));
                break;
            }
            case 5: {
                if (_char.user.player.ItemBagSlotNull() < 2) {
                    GameCanvas.startOKDlg(_char.user.session, Text.get(0, 15));
                    return;
                }
                Service.openUISay(_char, npcTemplateId, Talk.getTask(0, 40));
                _char.user.player.upCoinLock(500L, (byte)1);
                _char.updateExp(4000L);
                _char.user.player.ItemBagAdd(new Item(null, (short)13, 5, -1, true, (byte)0, 0));
                _char.user.player.ItemBagAdd(new Item(null, (short)18, 5, -1, true, (byte)0, 0));
                break;
            }
            case 6: {
                Service.openUISay(_char, npcTemplateId, Talk.getTask(0, 43));
                _char.user.player.upCoinLock(600L, (byte)1);
                _char.updateExp(5000L);
                break;
            }
            case 7: {
                if (_char.user.player.ItemBagSlotNull() < 1) {
                    GameCanvas.startOKDlg(_char.user.session, Text.get(0, 15));
                    return;
                }
                Service.openUISay(_char, npcTemplateId, Talk.getTask(0, 43));
                _char.user.player.upCoinLock(700L, (byte)1);
                _char.updateExp(8000L);
                _char.user.player.ItemBagAdd(new Item(new ItemOption[] { new ItemOption(47, Util.nextInt(0, 1)), new ItemOption(6, Util.nextInt(0, 5)), new ItemOption(7, Util.nextInt(0, 5)) }, (short)205, 1, -1, true, (byte)Util.nextInt(1, 3), 5));
                break;
            }
            case 8: {
                if (_char.user.player.ItemBagSlotNull() < 2) {
                    GameCanvas.startOKDlg(_char.user.session, Text.get(0, 15));
                    return;
                }
                Service.openUISay(_char, npcTemplateId, Talk.getTask(0, 115));
                _char.user.player.upCoinLock(800L, (byte)1);
                _char.updateExp(24080L);
                _char.user.player.ItemBagAdd(new Item(null, (short)37, 1, 604800, true, (byte)0, 0));
                _char.user.player.ItemBagAdd(new Item(null, (short)225, 1, -1, true, (byte)0, 0));
                break;
            }
            case 9: {
                if (_char.user.player.ItemBagSlotNull() < 1) {
                    GameCanvas.startOKDlg(_char.user.session, Text.get(0, 15));
                    return;
                }
                Service.openUISay(_char, npcTemplateId, Talk.getTask(0, 117));
                _char.user.player.upCoinLock(900L, (byte)1);
                _char.updateExp(5000L);
                _char.user.player.ItemBagAdd(new Item(null, (short)2, 1, -1, true, (byte)0, 0));
                break;
            }
            case 10: {
                Service.openUISay(_char, npcTemplateId, Talk.getTask(0, 120));
                _char.user.player.upCoinLock(1000L, (byte)1);
                _char.updateExp(5000L);
                break;
            }
            case 11: {
                if (_char.user.player.ItemBagSlotNull() < 6) {
                    GameCanvas.startOKDlg(_char.user.session, Text.get(0, 15));
                    return;
                }
                Service.openUISay(_char, npcTemplateId, Talk.getTask(0, 123));
                _char.user.player.upCoinLock(1000L, (byte)1);
                _char.updateExp(5000L);
                _char.user.player.ItemBagAdd(new Item(null, (short)222, 1, -1, true, (byte)0, 0));
                _char.user.player.ItemBagAdd(new Item(null, (short)223, 1, -1, true, (byte)0, 0));
                _char.user.player.ItemBagAdd(new Item(null, (short)224, 1, -1, true, (byte)0, 0));
                _char.user.player.ItemBagAdd(new Item(null, (short)226, 1, -1, true, (byte)0, 0));
                _char.user.player.ItemBagAdd(new Item(null, (short)227, 1, -1, true, (byte)0, 0));
                _char.user.player.ItemBagAdd(new Item(null, (short)228, 1, -1, true, (byte)0, 0));
                _char.ctaskId = (byte)GameScr.tasks.length;
                _char.clearTask();
                for (byte i = _char.ctaskId; i <= GameScr.tasks.length; ++i) {
                    Service.nextTask(_char);
                }
                Service.updateInfoMe(_char);
                return;
            }
        }
        _char.uptaskMaint();
        _char.clearTask();
    }
    
    protected static void getTask(final Char _char, final byte npcTemplateId, final byte menuId, final byte optionId) {
        if (isTaskNPC(_char, npcTemplateId) && TileMap.NPCNear(_char, npcTemplateId) != null) {
            if (menuId == 0 && _char.ctaskIndex == -1) {
                _char.ctaskIndex = 0;
                Service.getTask(_char);
                switch (_char.ctaskId) {
                    case 0: {
                        Service.openUISay(_char, npcTemplateId, Talk.getTask(0, 8));
                        break;
                    }
                    case 1: {
                        Service.openUISay(_char, npcTemplateId, Talk.getTask(0, 10));
                        break;
                    }
                    case 2: {
                        Service.openUISay(_char, npcTemplateId, Talk.getTask(0, 28));
                        if (_char.ItemBody[1] != null) {
                            _char.uptaskMaint();
                            break;
                        }
                        break;
                    }
                    case 3: {
                        Service.openUISay(_char, npcTemplateId, Talk.getTask(0, 31));
                        break;
                    }
                    case 4: {
                        Service.openUISay(_char, npcTemplateId, Talk.getTask(0, 36));
                        break;
                    }
                    case 5: {
                        Service.openUISay(_char, npcTemplateId, Talk.getTask(0, 39));
                        break;
                    }
                    case 6: {
                        Service.openUISay(_char, npcTemplateId, Talk.getTask(0, 42));
                        break;
                    }
                    case 7: {
                        Service.openUISay(_char, npcTemplateId, Talk.getTask(0, 45));
                        break;
                    }
                    case 8: {
                        Service.openUISay(_char, npcTemplateId, Talk.getTask(0, 111));
                        break;
                    }
                    case 9: {
                        if (_char.ASkill.size() > 0) {
                            _char.uptaskMaint();
                            _char.uptaskMaint();
                            break;
                        }
                        break;
                    }
                    case 10: {
                        Service.openUISay(_char, npcTemplateId, Talk.getTask(0, 119));
                        break;
                    }
                    case 11: {
                        Service.openUISay(_char, npcTemplateId, Talk.getTask(0, 122));
                        break;
                    }
                }
                requestLevel(_char);
            }
            else if (_char.ctaskId == 1) {
                if (_char.ctaskIndex == 0) {
                    if (menuId == 1) {
                        _char.uptaskMaint();
                        Service.openUIConfirm(_char, npcTemplateId, Talk.getTask(0, 13), new String[] { Talk.getTask(0, 19), Talk.getTask(0, 20), Talk.getTask(0, 18) });
                    }
                    else {
                        Service.openUIConfirm(_char, npcTemplateId, String.format(Talk.getTask(0, 24), Talk.getTask(0, 12)), new String[] { Talk.getTask(0, 17), Talk.getTask(0, 18), Talk.getTask(0, 19) });
                    }
                }
                else if (_char.ctaskIndex == 1) {
                    if (menuId == 0) {
                        _char.uptaskMaint();
                        Service.openUIConfirm(_char, npcTemplateId, Talk.getTask(0, 14), new String[] { Talk.getTask(0, 18), Talk.getTask(0, 17), Talk.getTask(0, 21) });
                    }
                    else {
                        Service.openUIConfirm(_char, npcTemplateId, String.format(Talk.getTask(0, 24), Talk.getTask(0, 13)), new String[] { Talk.getTask(0, 19), Talk.getTask(0, 20), Talk.getTask(0, 18) });
                    }
                }
                else if (_char.ctaskIndex == 2) {
                    if (menuId == 1) {
                        _char.uptaskMaint();
                        Service.openUIConfirm(_char, npcTemplateId, Talk.getTask(0, 15), new String[] { Talk.getTask(0, 22), Talk.getTask(0, 18), Talk.getTask(0, 23) });
                    }
                    else {
                        Service.openUIConfirm(_char, npcTemplateId, String.format(Talk.getTask(0, 24), Talk.getTask(0, 14)), new String[] { Talk.getTask(0, 18), Talk.getTask(0, 17), Talk.getTask(0, 21) });
                    }
                }
                else if (_char.ctaskIndex == 3) {
                    if (menuId == 2) {
                        _char.uptaskMaint();
                        Service.openUIConfirm(_char, npcTemplateId, Talk.getTask(0, 16), new String[] { Talk.getTask(0, 20), Talk.getTask(0, 23), Talk.getTask(0, 19) });
                    }
                    else {
                        Service.openUIConfirm(_char, npcTemplateId, String.format(Talk.getTask(0, 24), Talk.getTask(0, 15)), new String[] { Talk.getTask(0, 22), Talk.getTask(0, 18), Talk.getTask(0, 23) });
                    }
                }
                else if (_char.ctaskIndex == 4) {
                    if (menuId == 0) {
                        _char.uptaskMaint();
                        Service.openUISay(_char, npcTemplateId, Talk.getTask(0, 25));
                    }
                    else {
                        Service.openUIConfirm(_char, npcTemplateId, String.format(Talk.getTask(0, 24), Talk.getTask(0, 16)), new String[] { Talk.getTask(0, 20), Talk.getTask(0, 23), Talk.getTask(0, 19) });
                    }
                }
            }
            else if (_char.ctaskId == 7) {
                if (_char.ctaskIndex == 1) {
                    if (menuId == 1) {
                        _char.uptaskMaint();
                        Service.openUIConfirm(_char, npcTemplateId, Talk.getTask(0, 50), new String[] { Talk.getTask(0, 51), Talk.getTask(0, 52), Talk.getTask(0, 53) });
                    }
                    else {
                        Service.openUIConfirm(_char, npcTemplateId, String.format(Talk.getTask(0, 24), Talk.getTask(0, 49)), new String[] { Talk.getTask(0, 46), Talk.getTask(0, 47), Talk.getTask(0, 48) });
                    }
                }
                else if (_char.ctaskIndex == 2) {
                    if (menuId == 0) {
                        _char.uptaskMaint();
                        Service.openUIConfirm(_char, npcTemplateId, Talk.getTask(0, 54), new String[] { Talk.getTask(0, 55), Talk.getTask(0, 56), Talk.getTask(0, 57) });
                    }
                    else {
                        Service.openUIConfirm(_char, npcTemplateId, String.format(Talk.getTask(0, 24), Talk.getTask(0, 50)), new String[] { Talk.getTask(0, 51), Talk.getTask(0, 52), Talk.getTask(0, 53) });
                    }
                }
                else if (_char.ctaskIndex == 3) {
                    if (menuId == 1) {
                        _char.uptaskMaint();
                        Service.openUIConfirm(_char, npcTemplateId, Talk.getTask(0, 58), new String[] { Talk.getTask(0, 59), Talk.getTask(0, 60), Talk.getTask(0, 61) });
                    }
                    else {
                        Service.openUIConfirm(_char, npcTemplateId, String.format(Talk.getTask(0, 24), Talk.getTask(0, 54)), new String[] { Talk.getTask(0, 55), Talk.getTask(0, 56), Talk.getTask(0, 57) });
                    }
                }
                else if (_char.ctaskIndex == 4) {
                    if (menuId == 1) {
                        _char.uptaskMaint();
                        Service.openUIConfirm(_char, npcTemplateId, Talk.getTask(0, 62), new String[] { Talk.getTask(0, 63), Talk.getTask(0, 64), Talk.getTask(0, 65) });
                    }
                    else {
                        Service.openUIConfirm(_char, npcTemplateId, String.format(Talk.getTask(0, 24), Talk.getTask(0, 58)), new String[] { Talk.getTask(0, 59), Talk.getTask(0, 60), Talk.getTask(0, 61) });
                    }
                }
                else if (_char.ctaskIndex == 5) {
                    if (menuId == 2) {
                        _char.uptaskMaint();
                        Service.openUISay(_char, npcTemplateId, Talk.getTask(0, 66));
                    }
                    else {
                        Service.openUIConfirm(_char, npcTemplateId, String.format(Talk.getTask(0, 24), Talk.getTask(0, 62)), new String[] { Talk.getTask(0, 63), Talk.getTask(0, 64), Talk.getTask(0, 65) });
                    }
                }
                else if (_char.ctaskIndex == 6) {
                    if (menuId == 2) {
                        _char.uptaskMaint();
                        Service.openUIConfirm(_char, npcTemplateId, Talk.getTask(0, 71), new String[] { Talk.getTask(0, 72), Talk.getTask(0, 73), Talk.getTask(0, 74) });
                    }
                    else {
                        Service.openUIConfirm(_char, npcTemplateId, String.format(Talk.getTask(0, 24), Talk.getTask(0, 67)), new String[] { Talk.getTask(0, 68), Talk.getTask(0, 69), Talk.getTask(0, 70) });
                    }
                }
                else if (_char.ctaskIndex == 7) {
                    if (menuId == 0) {
                        _char.uptaskMaint();
                        Service.openUIConfirm(_char, npcTemplateId, Talk.getTask(0, 75), new String[] { Talk.getTask(0, 76), Talk.getTask(0, 77), Talk.getTask(0, 78) });
                    }
                    else {
                        Service.openUIConfirm(_char, npcTemplateId, String.format(Talk.getTask(0, 24), Talk.getTask(0, 71)), new String[] { Talk.getTask(0, 72), Talk.getTask(0, 73), Talk.getTask(0, 74) });
                    }
                }
                else if (_char.ctaskIndex == 8) {
                    if (menuId == 2) {
                        _char.uptaskMaint();
                        Service.openUIConfirm(_char, npcTemplateId, Talk.getTask(0, 79), new String[] { Talk.getTask(0, 80), Talk.getTask(0, 81), Talk.getTask(0, 82) });
                    }
                    else {
                        Service.openUIConfirm(_char, npcTemplateId, String.format(Talk.getTask(0, 24), Talk.getTask(0, 75)), new String[] { Talk.getTask(0, 76), Talk.getTask(0, 77), Talk.getTask(0, 78) });
                    }
                }
                else if (_char.ctaskIndex == 9) {
                    if (menuId == 2) {
                        _char.uptaskMaint();
                        Service.openUIConfirm(_char, npcTemplateId, Talk.getTask(0, 83), new String[] { Talk.getTask(0, 84), Talk.getTask(0, 85), Talk.getTask(0, 86) });
                    }
                    else {
                        Service.openUIConfirm(_char, npcTemplateId, String.format(Talk.getTask(0, 24), Talk.getTask(0, 79)), new String[] { Talk.getTask(0, 80), Talk.getTask(0, 81), Talk.getTask(0, 82) });
                    }
                }
                else if (_char.ctaskIndex == 10) {
                    if (menuId == 1) {
                        _char.uptaskMaint();
                        Service.openUISay(_char, npcTemplateId, Talk.getTask(0, 87));
                    }
                    else {
                        Service.openUIConfirm(_char, npcTemplateId, String.format(Talk.getTask(0, 24), Talk.getTask(0, 83)), new String[] { Talk.getTask(0, 84), Talk.getTask(0, 85), Talk.getTask(0, 86) });
                    }
                }
                else if (_char.ctaskIndex == 11) {
                    if (menuId == 0) {
                        _char.uptaskMaint();
                        Service.openUIConfirm(_char, npcTemplateId, Talk.getTask(0, 92), new String[] { Talk.getTask(0, 93), Talk.getTask(0, 94), Talk.getTask(0, 95) });
                    }
                    else {
                        Service.openUIConfirm(_char, npcTemplateId, String.format(Talk.getTask(0, 24), Talk.getTask(0, 88)), new String[] { Talk.getTask(0, 89), Talk.getTask(0, 90), Talk.getTask(0, 91) });
                    }
                }
                else if (_char.ctaskIndex == 12) {
                    if (menuId == 1) {
                        _char.uptaskMaint();
                        Service.openUIConfirm(_char, npcTemplateId, Talk.getTask(0, 96), new String[] { Talk.getTask(0, 97), Talk.getTask(0, 98), Talk.getTask(0, 99) });
                    }
                    else {
                        Service.openUIConfirm(_char, npcTemplateId, String.format(Talk.getTask(0, 24), Talk.getTask(0, 92)), new String[] { Talk.getTask(0, 93), Talk.getTask(0, 94), Talk.getTask(0, 95) });
                    }
                }
                else if (_char.ctaskIndex == 13) {
                    if (menuId == 2) {
                        _char.uptaskMaint();
                        Service.openUIConfirm(_char, npcTemplateId, Talk.getTask(0, 100), new String[] { Talk.getTask(0, 101), Talk.getTask(0, 102), Talk.getTask(0, 103) });
                    }
                    else {
                        Service.openUIConfirm(_char, npcTemplateId, String.format(Talk.getTask(0, 24), Talk.getTask(0, 96)), new String[] { Talk.getTask(0, 97), Talk.getTask(0, 98), Talk.getTask(0, 99) });
                    }
                }
                else if (_char.ctaskIndex == 14) {
                    if (menuId == 2) {
                        _char.uptaskMaint();
                        Service.openUIConfirm(_char, npcTemplateId, Talk.getTask(0, 104), new String[] { Talk.getTask(0, 105), Talk.getTask(0, 106), Talk.getTask(0, 107) });
                    }
                    else {
                        Service.openUIConfirm(_char, npcTemplateId, String.format(Talk.getTask(0, 24), Talk.getTask(0, 100)), new String[] { Talk.getTask(0, 101), Talk.getTask(0, 102), Talk.getTask(0, 103) });
                    }
                }
                else if (_char.ctaskIndex == 15) {
                    if (menuId == 1) {
                        _char.uptaskMaint();
                        Service.openUISay(_char, npcTemplateId, Talk.getTask(0, 108));
                    }
                    else {
                        Service.openUIConfirm(_char, npcTemplateId, String.format(Talk.getTask(0, 24), Talk.getTask(0, 104)), new String[] { Talk.getTask(0, 105), Talk.getTask(0, 106), Talk.getTask(0, 107) });
                    }
                }
            }
        }
    }
    
    protected static boolean isTaskNPC(final Char _char, final short npcTemplateId) {
        if (_char.ctaskId < GameScr.tasks.length) {
            try {
                if (GameScr.tasks[_char.ctaskId][_char.ctaskIndex + 1] == -1 && _char.nClass != 0) {
                    return (npcTemplateId == 9 && _char.sys() == 1) || (npcTemplateId == 10 && _char.sys() == 2) || (npcTemplateId == 11 && _char.sys() == 3);
                }
                return GameScr.tasks[_char.ctaskId][_char.ctaskIndex + 1] == npcTemplateId;
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }
    
    protected static boolean isFinishTask(final Char _char) {
        try {
            return GameScr.taskTemplates[_char.ctaskId].subNames.length == _char.ctaskIndex + 1;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    protected static boolean isExtermination(final Char _char, final Mob mob) {
        switch (mob.templateId) {
            case 0: {
                if (_char.ctaskId == 2 && _char.ctaskIndex == 1) {
                    return true;
                }
                break;
            }
            case 1: {
                if (_char.ctaskId == 3 && _char.ctaskIndex == 2) {
                    return true;
                }
                break;
            }
            case 2: {
                if (_char.ctaskId == 3 && _char.ctaskIndex == 3) {
                    return true;
                }
                break;
            }
            case 5: {
                if (_char.ctaskId == 10 && _char.ctaskIndex == 0) {
                    return true;
                }
                break;
            }
            case 6: {
                if (_char.ctaskId == 10 && _char.ctaskIndex == 1) {
                    return true;
                }
                break;
            }
            case 7: {
                if (_char.ctaskId == 10 && _char.ctaskIndex == 2) {
                    return true;
                }
                break;
            }
        }
        return false;
    }
    
    protected static void requestLevel(final Char _char) {
        switch (_char.ctaskId) {
            case 4: {
                if (_char.ctaskIndex == 0 && _char.cLevel > 4) {
                    _char.uptaskMaint();
                    break;
                }
                break;
            }
            case 5: {
                if (_char.ctaskIndex == 0 && _char.cLevel > 5) {
                    _char.uptaskMaint();
                    break;
                }
                break;
            }
            case 6: {
                if (_char.ctaskIndex == 0 && _char.cLevel > 6) {
                    _char.uptaskMaint();
                    break;
                }
                break;
            }
            case 7: {
                if (_char.ctaskIndex == 0 && _char.cLevel > 7) {
                    _char.uptaskMaint();
                    break;
                }
                break;
            }
            case 8: {
                if (_char.ctaskIndex == 0 && _char.cLevel > 8) {
                    _char.uptaskMaint();
                    break;
                }
                break;
            }
            case 11: {
                if (_char.ctaskIndex == 0 && _char.cLevel > 10) {
                    _char.uptaskMaint();
                    break;
                }
                break;
            }
            case 12: {
                if (_char.ctaskIndex == 0 && _char.cLevel > 11) {
                    _char.uptaskMaint();
                    break;
                }
                break;
            }
            case 13: {
                if (_char.ctaskIndex == 0 && _char.cLevel > 13) {
                    _char.uptaskMaint();
                    break;
                }
                break;
            }
            case 14: {
                if (_char.ctaskIndex == 0 && _char.cLevel > 15) {
                    _char.uptaskMaint();
                    break;
                }
                break;
            }
        }
        inMap(_char);
    }
    
    protected static short itemTemplateId(final Char _char, final Mob mob) {
        switch (_char.ctaskId) {
            case 4: {
                if (_char.ctaskIndex == 1 && mob.templateId == 3) {
                    return 209;
                }
                if (_char.ctaskIndex == 2 && mob.templateId == 4) {
                    return 210;
                }
                break;
            }
            case 5: {
                if (_char.ctaskIndex == 1 && mob.templateId == 54) {
                    return 211;
                }
                break;
            }
        }
        return -1;
    }
    
    protected static boolean itemPick(final Char _char, final short itemTemplateId) {
        switch (_char.ctaskId) {
            case 4: {
                if (_char.ctaskIndex == 1 && itemTemplateId == 209) {
                    return true;
                }
                if (_char.ctaskIndex == 2 && itemTemplateId == 210) {
                    return true;
                }
                break;
            }
            case 5: {
                if (_char.ctaskIndex == 1 && itemTemplateId == 211) {
                    return true;
                }
                break;
            }
        }
        return false;
    }
    
    protected static void inMap(final Char _char) {
        switch (_char.ctaskId) {
            case 6: {
                if (_char.ctaskIndex == 1 && _char.tileMap.mapID == 2) {
                    _char.uptaskMaint();
                    break;
                }
                if (_char.ctaskIndex == 2 && _char.tileMap.mapID == 71) {
                    _char.uptaskMaint();
                    break;
                }
                if (_char.ctaskIndex == 3 && _char.tileMap.mapID == 26) {
                    _char.uptaskMaint();
                    break;
                }
                break;
            }
        }
    }
    
    protected static boolean isLockChangeMap(final short mapID, final byte TaskId) {
        switch (TaskId) {
            case 0:
            case 1:
            case 2: {
                return mapID != 22;
            }
            case 3:
            case 4: {
                return mapID != 21 && mapID != 22 && mapID != 23;
            }
            case 5: {
                return mapID != 6 && mapID != 20 && mapID != 21 && mapID != 22 && mapID != 23;
            }
            case 6: {
                return mapID != 2 && mapID != 6 && mapID != 20 && mapID != 21 && mapID != 22 && mapID != 23 && mapID != 25 && mapID != 26 && mapID != 69 && mapID != 70 && mapID != 71;
            }
            case 7:
            case 8: {
                return mapID != 1 && mapID != 2 && mapID != 6 && mapID != 20 && mapID != 21 && mapID != 22 && mapID != 23 && mapID != 25 && mapID != 26 && mapID != 27 && mapID != 69 && mapID != 70 && mapID != 71 && mapID != 72;
            }
            default: {
                return false;
            }
        }
    }
    
    protected static boolean isLockChangeMap2(final short mapID, final byte TaskId) {
        switch (TaskId) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8: {
                return mapID == 1 || mapID == 10 || mapID == 17 || mapID == 27 || mapID == 32 || mapID == 38 || mapID == 43 || mapID == 48 || mapID == 72;
            }
            default: {
                return false;
            }
        }
    }
}
