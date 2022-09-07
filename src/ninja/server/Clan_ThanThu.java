package ninja.server;

import java.util.ArrayList;

public class Clan_ThanThu
{
    public static short[] arrIdTrung;
    public static short[][] arriconIdThanThu;
    public static short[] arrIdThanThu;
    public String name;
    public byte stars;
    public short idIconItem;
    public short idThanThu;
    public int time_aptrung;
    public String str_trungno;
    public ArrayList<String> vecInfo;
    public int curExp;
    public int maxExp;
    public long timeStartThanThu;
    
    public Clan_ThanThu() {
        this.name = "";
        this.time_aptrung = -1;
        this.str_trungno = "";
        this.vecInfo = new ArrayList<String>();
        this.curExp = -1;
        this.maxExp = -1;
    }
    
    static {
        Clan_ThanThu.arrIdTrung = new short[] { 596, 601 };
        Clan_ThanThu.arriconIdThanThu = new short[][] { { 2506 }, { 2502 } };
        Clan_ThanThu.arrIdThanThu = new short[] { 2502, 2506 };
    }
}
