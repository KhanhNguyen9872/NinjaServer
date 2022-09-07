
package ninja.server;

import ninja.template.ItemTemplate;
import io.MySQL;
import org.json.simple.JSONArray;
import ninja.option.ItemOption;

public class ItemServer
{
    protected static final short[] arrItemUpMob;
    
    protected static Item itemWPShop(final int level, final byte Nclass, final byte type) {
        try {
            Item item = null;
            if (level == 1) {
                item = new Item(new ItemOption[] { new ItemOption(0, Util.nextInt(10, 20)), new ItemOption(8, Util.nextInt(4, 10)) }, (short)194, 1, -1, false, (byte)0, 5);
            }
            else {
                final Item[] arrItem = GameScr.itemStores.get(2);
                for (byte i = 0; i < arrItem.length; ++i) {
                    final Item itemStore = arrItem[i];
                    if (itemStore != null && itemStore.template.level == level && ((Nclass == 0 && itemStore.isItemClass0()) || (Nclass == 1 && itemStore.isItemClass1()) || (Nclass == 2 && itemStore.isItemClass2()) || (Nclass == 3 && itemStore.isItemClass3()) || (Nclass == 4 && itemStore.isItemClass4()) || (Nclass == 5 && itemStore.isItemClass5()) || (Nclass == 6 && itemStore.isItemClass6()))) {
                        item = itemStore.clone();
                        item.quantity = 1;
                    }
                }
            }
            if (item != null && type != 0) {
                if (type == 2) {
                    for (int j = item.options.size() - 1; j >= 0; --j) {
                        final ItemOption option = item.options.get(j);
                        if (option != null && (option.optionTemplate.type == 0 || option.optionTemplate.type == 1 || option.optionTemplate.type == 2) && Util.nextInt(100) < 60) {
                            item.options.remove(j);
                        }
                    }
                    item.saleCoinLock = 5;
                }
                for (short k = 0; k < item.options.size(); ++k) {
                    final ItemOption option = item.options.get(k);
                    if (option != null) {
                        option.param = Util.nextInt(option.getOptionShopParam(), option.param);
                    }
                }
            }
            return item;
        }
        catch (Exception e) {
            return null;
        }
    }
    
    protected static Item getItemStore(final short templateId, final byte sys, final byte type) {
        for (byte n = 0; n < 101; ++n) {
            final Item[] arrItem = GameScr.itemStores.get(n);
            if (arrItem != null) {
                if (n == 100) {}
                for (byte i = 0; i < arrItem.length; ++i) {
                    final Item itemStore = arrItem[i];
                    if (itemStore != null && itemStore.template.id == templateId && (itemStore.template.type == 1 || itemStore.sys == sys)) {
                        final Item item = itemStore.clone();
                        if (type == 1) {
                            for (short j = 0; j < item.options.size(); ++j) {
                                final ItemOption option = item.options.get(j);
                                if (option != null) {
                                    option.param = Util.nextInt(option.getOptionShopParam(), option.param);
                                }
                            }
                        }
                        item.quantity = 1;
                        return item;
                    }
                }
            }
        }
        return null;
    }
    
    protected static int itemParam(final short TemplateId) {
        switch (TemplateId) {
            case 18: {
                return 150;
            }
            case 19: {
                return 500;
            }
            case 20: {
                return 1000;
            }
            case 21: {
                return 2000;
            }
            case 22: {
                return 3500;
            }
            case 252:
            case 308: {
                return 1;
            }
            case 253:
            case 309: {
                return 10;
            }
            case 257: {
                return 5;
            }
            case 280: {
                return 1;
            }
            case 444: {
                return 200;
            }
            case 449: {
                return 5;
            }
            case 450: {
                return 7;
            }
            case 451: {
                return 14;
            }
            case 452: {
                return 20;
            }
            case 453: {
                return 25;
            }
            case 469: {
                return 200;
            }
            case 470: {
                return 5;
            }
            case 471: {
                return 14;
            }
            case 472: {
                return 25;
            }
            case 566: {
                return 5000;
            }
            case 573: {
                return 200;
            }
            case 574: {
                return 400;
            }
            case 575: {
                return 600;
            }
            case 576: {
                return 100;
            }
            case 577: {
                return 250;
            }
            case 578: {
                return 500;
            }
            default: {
                return 0;
            }
        }
    }
    
    protected static void thattoan() {
        final String str = "";
        final JSONArray itemStores = new JSONArray();
        for (int n = 0; n < 10; ++n) {
            for (int i = 0; i < 34; ++i) {
                final Item[] arrItem = GameScr.itemStores.get((byte)i);
                if (arrItem != null) {
                    for (byte j = 0; j < arrItem.length; ++j) {
                        final Item itemStore = arrItem[j];
                        if (itemStore != null && itemStore.template.type == n && itemStore.template.level >= 80) {
                            final Item item = itemStore.clone();
                            for (int k = 0; k < GameScr.itemTemplates.length; ++k) {
                                final Item item2 = new Item(null, GameScr.itemTemplates[k].id, 1, -1, false, (byte)0, 5);
                                if (GameScr.itemTemplates[k].level >= 90 && GameScr.itemTemplates[k].type == item.template.type && (item.template.gender == 2 || item.template.gender == item2.template.gender) && (item.template.type != 1 || (item.isItemClass1() && item2.isItemClass1()) || (item.isItemClass2() && item2.isItemClass2()) || (item.isItemClass3() && item2.isItemClass3()) || (item.isItemClass4() && item2.isItemClass4()) || (item.isItemClass5() && item2.isItemClass5()) || (item.isItemClass6() && item2.isItemClass6()))) {
                                    final Item item3 = item;
                                    final ItemTemplate[] itemTemplates = GameScr.itemTemplates;
                                    final Item item4 = item;
                                    final short id = GameScr.itemTemplates[k].id;
                                    item4.itemId = id;
                                    item3.template = itemTemplates[id];
                                    System.out.println("_____________________________ " + item.template.name);
                                    break;
                                }
                            }
                            item.saleCoinLock = item.saleCoinLockDefault() * 10;
                            if (item.template.type != 1) {
                                if (item.template.type == 2 || item.template.type == 6) {
                                    final ItemOption itemOption = item.options.get(0);
                                    itemOption.param += 4;
                                }
                                else {
                                    final ItemOption itemOption2 = item.options.get(0);
                                    itemOption2.param += 2;
                                }
                                final ItemOption itemOption3 = item.options.get(1);
                                itemOption3.param += 10;
                                final ItemOption itemOption4 = item.options.get(2);
                                itemOption4.param += 50;
                                final ItemOption itemOption5 = item.options.get(3);
                                itemOption5.param += 50;
                                final ItemOption itemOption6 = item.options.get(4);
                                itemOption6.param += 10;
                                if (item.template.type == 8) {
                                    final ItemOption itemOption7 = item.options.get(5);
                                    itemOption7.param += 5;
                                }
                                else {
                                    final ItemOption itemOption8 = item.options.get(5);
                                    itemOption8.param += 10;
                                }
                                final ItemOption itemOption9 = item.options.get(6);
                                itemOption9.param += 16;
                                final ItemOption itemOption10 = item.options.get(7);
                                ++itemOption10.param;
                                final ItemOption itemOption11 = item.options.get(8);
                                itemOption11.param += 50;
                                final ItemOption itemOption12 = item.options.get(9);
                                itemOption12.param += 20;
                            }
                            else {
                                final ItemOption itemOption13 = item.options.get(0);
                                itemOption13.param += 220;
                                final ItemOption itemOption14 = item.options.get(1);
                                itemOption14.param += 220;
                                final ItemOption itemOption15 = item.options.get(2);
                                itemOption15.param += 50;
                                final ItemOption itemOption16 = item.options.get(3);
                                itemOption16.param += 10;
                                final ItemOption itemOption17 = item.options.get(4);
                                itemOption17.param += 400;
                                final ItemOption itemOption18 = item.options.get(5);
                                itemOption18.param += 50;
                                final ItemOption itemOption19 = item.options.get(6);
                                itemOption19.param += 2;
                                final ItemOption itemOption20 = item.options.get(7);
                                itemOption20.param += 10;
                                final ItemOption itemOption21 = item.options.get(8);
                                itemOption21.param += 100;
                                final ItemOption itemOption22 = item.options.get(9);
                                itemOption22.param += 20;
                            }
                            itemStores.add((Object)item);
                        }
                    }
                }
            }
        }
        try {
            final MySQL mySQL = new MySQL(1);
            try {
                mySQL.stat.executeUpdate("UPDATE `itemstore` SET `itemStores`='" + itemStores.toJSONString() + "' WHERE `type`=" + 100 + ";");
            }
            finally {
                mySQL.close();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("str Item " + str);
    }
    
    static {
        arrItemUpMob = new short[0];
    }
}
