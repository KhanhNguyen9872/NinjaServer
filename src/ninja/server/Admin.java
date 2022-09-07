package ninja.server;

public class Admin
{
    private static final String[] admins;
    protected static String PlayerName;
    
    protected static void opMenu(final Char _char) {
        boolean isadmin = false;
        for (byte i = 0; i < Admin.admins.length; ++i) {
            if (_char.cName.equals(Admin.admins[i])) {
                isadmin = true;
                break;
            }
        }
        if (isadmin) {
            Admin.PlayerName = "";
            _char.menuType = -125;
            Service.openUIMenuNew(_char, new String[] { "Th\u1ed1ng k\u00ea", "B\u1ea3o tr\u00ec", "L\u01b0u d\u1eef li\u1ec7u", "\u0110\u00f3ng b\u0103ng", "S\u1ef1 ki\u1ec7n", "Th\u00f4ng b\u00e1o", "Ph\u00e1t l\u01b0\u1ee3ng server" });
        }
    }
    
    protected static void Comand(final Char _char, final int cmd, final String str) {
        boolean isadmin = false;
        for (byte i = 0; i < Admin.admins.length; ++i) {
            if (_char.cName.equals(Admin.admins[i])) {
                isadmin = true;
                break;
            }
        }
        if (isadmin) {
            switch (cmd) {
                case 0: {
                    Admin.PlayerName = str;
                    Service.openTextBoxUI(_char, "Gi\u1edd \u0111\u00f3ng b\u0103ng", (short)(-101));
                    break;
                }
                case 1: {
                    try {
                        final int time = Integer.parseInt(str) * 1000 * 60 * 60;
                        final Player player = Client.getPlayer(Admin.PlayerName);
                        Char.setEffect(player, (byte)6, (int)(System.currentTimeMillis() / 1000L), time, (short)0, null, (byte)1);
                    }
                    catch (Exception e) {
                        opMenu(_char);
                    }
                    break;
                }
                case 2: {
                    try {
                        GameScr.vEvent = Byte.parseByte(str);
                        GameCanvas.startOKDlg(_char.user.session, "\u0110\u00e3 ch\u1ec9nh s\u1eeda s\u1ef1 ki\u1ec7n th\u00e0nh c\u00f4ng ID s\u1ef1 ki\u1ec7n l\u00e0: " + GameScr.vEvent);
                    }
                    catch (Exception e) {
                        Service.ServerMessage(_char, "Nh\u1eadp gi\u00e1 tr\u1ecb l\u00e0 s\u1ed1.");
                    }
                    break;
                }
                case 3: {
                    Client.startOKDlgServer(str);
                    break;
                }
                case 4: {
                    try {
                        GameCanvas.startOKDlg(_char.user.session, "\u0110\u00e3 ph\u00e1t l\u01b0\u1ee3ng cho to\u00e0n m\u00e1y ch\u1ee7");
                        final int num32 = Integer.parseInt(str);
                        synchronized (Client.LOCK) {
                            for (int j = 0; j < Client.clients.size(); ++j) {
                                final Session_ME player2 = Client.clients.get(j);
                                if (player2 != null && player2.user != null && player2.user.player != null) {
                                    player2.user.player.upGold(num32, (byte)2);
                                }
                            }
                        }
                    }
                    catch (Exception e) {
                        Service.ServerMessage(_char, "Nh\u1eadp gi\u00e1 tr\u1ecb l\u00e0 s\u1ed1.");
                    }
                    break;
                }
            }
        }
    }
    
    protected static void controller(final Char _char, final byte menuId) {
        boolean isadmin = false;
        for (byte i = 0; i < Admin.admins.length; ++i) {
            if (_char.cName.equals(Admin.admins[i])) {
                isadmin = true;
                break;
            }
        }
        if (isadmin) {
            switch (menuId) {
                case 0: {
                    Service.AlertMessage(_char, "Th\u1ed1ng K\u00ea", "- \u0110ang online: " + Client.sizeUser());
                    break;
                }
                case 1: {
                    Client.startOKDlgServer("Server s\u1ebd b\u1ea3o tr\u00ec sau 1 ph\u00fat n\u1eefa. Vui l\u00f2ng tho\u00e1t tr\u00f2 ch\u01a1i \u0111\u1ec3 kh\u00f4ng b\u1ecb m\u1ea5t d\u1eef li\u1ec7u.");
                    Server.close(10000);
                    break;
                }
                case 2: {
                    Service.ServerMessage(_char, "\u0110ang l\u01b0u d\u1eef li\u1ec7u...");
                    try {
                        for (int j = Client.clients.size() - 1; j >= 0; --j) {
                            final Session_ME conn = Client.clients.get(j);
                            if (conn != null && conn.user != null) {
                                conn.setBackupTime(10, false);
                            }
                        }
                        for (int j = 0; j < Clan.Aclan.size(); ++j) {
                            final Clan clan = Clan.Aclan.get(j);
                            if (clan != null) {
                                clan.flush();
                            }
                        }
                        ItemStands.flush();
                        ItemWait.flush();
                    }
                    catch (Exception e) {
                        e.printStackTrace();
                    }
                    Top.saveTopFile((byte)1);
                    Service.ServerMessage(_char, "\u0110\u00e3 l\u01b0u d\u1eef li\u1ec7u ho\u00e0n t\u1ea5t");
                    break;
                }
                case 3: {
                    Service.openTextBoxUI(_char, "T\u00ean nick \u0111\u00f3ng b\u0103ng", (short)(-100));
                    break;
                }
                case 4: {
                    Service.openTextBoxUI(_char, "ID S\u1ef1 ki\u1ec7n", (short)(-102));
                    break;
                }
                case 5: {
                    Service.openTextBoxUI(_char, "Th\u00f4ng b\u00e1o", (short)(-103));
                    break;
                }
                case 6: {
                    Service.openTextBoxUI(_char, "L\u01b0\u1ee3ng ph\u00e1t cho c\u1ea3 server", (short)(-104));
                    break;
                }
            }
        }
    }
    
    static {
        admins = new String[] { "vantu", "ginom4v", "admin", "yeugiang", "localhost" };
        Admin.PlayerName = "";
    }
}
