package ninja.server;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.time.Instant;
import io.MySQL;

public class DiamondSwap
{
    protected static final byte TYPE_GOLD = 0;
    protected static final byte TYPE_COIN = 1;
    protected static final byte TYPE_COINLOCK = 2;
    private static final int DIAMOND = 1;
    private static final float BALANCE_GOLD = 1.0f;
    private static final float BALANCE_COIN = 10000.0f;
    private static final float BALANCE_COINLOCK = 11000.0f;
    
    protected static void inputDiamond(final Char _char, final int num, final byte type) {
        switch (type) {
            case 0: {
                if (num > 0) {
                    try {
                        final MySQL mySQL = new MySQL(1);
                        try {
                            final ResultSet red = mySQL.stat.executeQuery("SELECT `vnd` FROM `user` WHERE `userId` = " + _char.user.userId + " LIMIT 1;");
                            red.first();
                            long diamond = red.getLong("vnd");
                            if (num > diamond) {
                                GameCanvas.startOKDlg(_char.user.session, String.format(Text.get(0, 256), Util.getFormatNumber(diamond)));
                            }
                            else {
                                mySQL.stat.executeUpdate("UPDATE `user` SET `vnd` = `vnd` - " + num + " WHERE `userId` = " + _char.user.userId + ";");
                                final int pre_gold = _char.user.luong;
                                final int pre_xu = _char.user.player.xu;
                                final int pre_yen = _char.user.player.yen;
                                final long pre_diamond = diamond;
                                final long nums = (long)(num * 1.0f);
                                diamond -= num;
                                GameCanvas.startOKDlg(_char.user.session, String.format(Text.get(0, 257), Util.getFormatNumber(nums)));
                                _char.user.player.upGold(nums, (byte)2);
                                _char.user.flush();
                                mySQL.stat.executeUpdate("INSERT INTO transfer(`userid`,`vndtruoc`,`vndsau`,`luongtruoc`,`luongsau`,`xutruoc`,`xusau`,`yentruoc`,`yensau`,`time`,`created_at`) VALUES (" + _char.user.userId + "," + pre_diamond + "," + diamond + "," + pre_gold + "," + _char.user.luong + "," + pre_xu + "," + _char.user.player.xu + "," + pre_yen + "," + _char.user.player.yen + "," + System.currentTimeMillis() / 1000L + ",'" + Util.toDateString(Date.from(Instant.now())) + "');");
                            }
                        }
                        finally {
                            mySQL.close();
                        }
                    }
                    catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                break;
            }
            case 1: {
                if (num > 0) {
                    try {
                        final MySQL mySQL = new MySQL(1);
                        try {
                            final ResultSet red = mySQL.stat.executeQuery("SELECT `vnd` FROM `user` WHERE `userId` = " + _char.user.userId + " LIMIT 1;");
                            red.first();
                            long diamond = red.getLong("vnd");
                            if (num > diamond) {
                                GameCanvas.startOKDlg(_char.user.session, String.format(Text.get(0, 256), Util.getFormatNumber(diamond)));
                            }
                            else {
                                mySQL.stat.executeUpdate("UPDATE `user` SET `vnd` = `vnd` - " + num + " WHERE `userId` = " + _char.user.userId + ";");
                                final int pre_gold = _char.user.luong;
                                final int pre_xu = _char.user.player.xu;
                                final int pre_yen = _char.user.player.yen;
                                final long pre_diamond = diamond;
                                final long nums = (long)(num * 10000.0f);
                                diamond -= num;
                                GameCanvas.startOKDlg(_char.user.session, String.format(Text.get(0, 258), Util.getFormatNumber(nums)));
                                _char.user.player.upCoin(nums, (byte)1);
                                _char.user.flush();
                                mySQL.stat.executeUpdate("INSERT INTO transfer(`userid`,`vndtruoc`,`vndsau`,`luongtruoc`,`luongsau`,`xutruoc`,`xusau`,`yentruoc`,`yensau`,`time`,`created_at`) VALUES (" + _char.user.userId + "," + pre_diamond + "," + diamond + "," + pre_gold + "," + _char.user.luong + "," + pre_xu + "," + _char.user.player.xu + "," + pre_yen + "," + _char.user.player.yen + "," + System.currentTimeMillis() / 1000L + ",'" + Util.toDateString(Date.from(Instant.now())) + "');");
                            }
                        }
                        finally {
                            mySQL.close();
                        }
                    }
                    catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                break;
            }
            case 2: {
                if (num > 0) {
                    try {
                        final MySQL mySQL = new MySQL(1);
                        try {
                            final ResultSet red = mySQL.stat.executeQuery("SELECT `vnd` FROM `user` WHERE `userId` = " + _char.user.userId + " LIMIT 1;");
                            red.first();
                            long diamond = red.getLong("vnd");
                            if (num > diamond) {
                                GameCanvas.startOKDlg(_char.user.session, String.format(Text.get(0, 256), Util.getFormatNumber(diamond)));
                            }
                            else {
                                mySQL.stat.executeUpdate("UPDATE `user` SET `vnd` = `vnd` - " + num + " WHERE `userId` = " + _char.user.userId + ";");
                                final int pre_gold = _char.user.luong;
                                final int pre_xu = _char.user.player.xu;
                                final int pre_yen = _char.user.player.yen;
                                final long pre_diamond = diamond;
                                final long nums = (long)(num * 11000.0f);
                                diamond -= num;
                                GameCanvas.startOKDlg(_char.user.session, String.format(Text.get(0, 259), Util.getFormatNumber(nums)));
                                _char.user.player.upCoinLock(nums, (byte)2);
                                _char.user.flush();
                                mySQL.stat.executeUpdate("INSERT INTO transfer(`userid`,`vndtruoc`,`vndsau`,`luongtruoc`,`luongsau`,`xutruoc`,`xusau`,`yentruoc`,`yensau`,`time`,`created_at`) VALUES (" + _char.user.userId + "," + pre_diamond + "," + diamond + "," + pre_gold + "," + _char.user.luong + "," + pre_xu + "," + _char.user.player.xu + "," + pre_yen + "," + _char.user.player.yen + "," + System.currentTimeMillis() / 1000L + ",'" + Util.toDateString(Date.from(Instant.now())) + "');");
                            }
                        }
                        finally {
                            mySQL.close();
                        }
                    }
                    catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                break;
            }
        }
    }
    
    protected static void viewDiamond(final Char _char) {
        try {
            final MySQL mySQL = new MySQL(1);
            try {
                final ResultSet red = mySQL.stat.executeQuery("SELECT `vnd` FROM `user` WHERE `userId` = " + _char.user.userId + " LIMIT 1;");
                red.first();
                final long diamond = red.getLong("vnd");
                GameCanvas.startOKDlg(_char.user.session, String.format(Text.get(0, 262), Util.getFormatNumber(diamond)));
            }
            finally {
                mySQL.close();
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    protected static void BangGia(final Char _char) {
        Service.AlertMessage(_char, Text.get(0, 260), String.format(Text.get(0, 261), Util.getFormatNumber(1L), Util.getFormatNumber(1L), Util.getFormatNumber(1L), Util.getFormatNumber(10000L), Util.getFormatNumber(1L), Util.getFormatNumber(11000L), String.valueOf(1.0f), String.valueOf(10000.0f), String.valueOf(11000.0f)));
    }
}
