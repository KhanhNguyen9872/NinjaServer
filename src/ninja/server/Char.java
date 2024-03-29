package ninja.server;

import ninja.template.EffectTemplate;
import ninja.template.TaskTemplate;
import ninja.option.ItemOption;
import ninja.option.SkillOption;
import io.Message;
import java.util.ArrayList;

public class Char
{
    protected static int baseId;
    protected User user;
    protected int playerId;
    protected int cloneId;
    protected int charID;
    protected byte ctaskId;
    protected byte ctaskIndex;
    protected short ctaskCount;
    protected byte cgender;
    protected short head;
    protected short leg;
    protected short body;
    protected short wp;
    protected short coat;
    protected short glove;
    protected byte cspeed;
    protected String cName;
    protected byte cPk;
    protected byte cTypePk;
    protected int cHP;
    protected int cMaxHP;
    protected int cMP;
    protected int cMaxMP;
    protected int cMiss;
    protected long cEXP;
    protected long cExpDown;
    protected long cExpR;
    protected int cLevel;
    protected byte nClass;
    protected short pPoint;
    protected byte refreshpPoint;
    protected short[] potential;
    protected short sPoint;
    protected byte refreshsPoint;
    protected short pointNon;
    protected short pointVukhi;
    protected short pointAo;
    protected short pointLien;
    protected short pointGangtay;
    protected short pointNhan;
    protected short pointQuan;
    protected short pointNgocboi;
    protected short pointGiay;
    protected short pointPhu;
    protected short[] nvDV;
    protected final ArrayList<Skill> ASkill;
    protected final ArrayList<Effect> aEff;
    protected byte[] KSkill;
    protected byte[] OSkill;
    protected byte[] CSkill;
    protected Skill myskill;
    protected Item[] ItemBody;
    protected Item[] ItemMounts;
    protected boolean isNhanban;
    protected boolean isHuman;
    protected boolean isBatNhanban;
    protected boolean isToNhanban;
    protected int timeLiveNhanban;
    protected int percentPow;
    protected Char[] arrChar;
    protected Char Nhanban;
    protected TileMap tileMap;
    protected byte statusMe;
    protected int mapId;
    protected int mapLTDId;
    protected short cx;
    protected short cy;
    protected ArrayList<Limit> ItemUseLimit;
    protected long timeSelectSkill;
    protected Mob mobFocus;
    protected Mob mobMe;
    protected byte menuType;
    protected Party party;
    protected final ArrayList<Please> aPartyInvite;
    protected final ArrayList<Please> aPartyInvate;
    protected String cClanName;
    protected byte ctypeClan;
    protected int pointClan;
    protected Member member;
    protected Clan clan;
    protected final ArrayList<Please> aClanInvite;
    protected final ArrayList<Please> aClanInvate;
    protected byte countPB;
    protected short pointPB;
    protected int timeFinishCave;
    protected byte countPartyPB;
    protected int caveId;
    protected int partyCaveId;
    protected short pointChienTruong;
    protected long lastTimeOnline;
    protected int testCharID;
    protected int delaytestCharID;
    protected boolean isTest;
    protected int KillCharId;
    protected boolean isCuuSat;
    protected int testDunCharID;
    protected int delaytestDunCharID;
    protected byte testDunPhe;
    protected int delaythacau;
    protected boolean isLockAttack;
    protected boolean isInvisible;
    protected boolean isDisable;
    protected boolean isDontMove;
    protected boolean isFire;
    protected boolean isIce;
    protected boolean isWind;
    protected boolean isBurn;
    protected boolean isThuCuoiHetHan;
    protected int timeBurn;
    protected short dXYBurn;
    protected final ArrayList<Mob> aBurn;
    protected int delayEffect;
    protected short[] setThoiTrang;
    protected final Object LOCK;
    private static final Object LOCK_LOCAL;
    
    protected Char(final User user) {
        this.user = null;
        this.cloneId = -1;
        this.charID = -9999;
        this.ctaskId = 0;
        this.ctaskIndex = -1;
        this.ctaskCount = 0;
        this.cgender = 3;
        this.head = -1;
        this.leg = -1;
        this.body = -1;
        this.wp = -1;
        this.coat = -1;
        this.glove = -1;
        this.cspeed = 4;
        this.cName = "";
        this.cPk = 0;
        this.cTypePk = 0;
        this.cHP = 0;
        this.cMaxHP = 0;
        this.cMP = 0;
        this.cMaxMP = 0;
        this.cMiss = 0;
        this.cEXP = 0L;
        this.cExpDown = 0L;
        this.cExpR = 0L;
        this.cLevel = 1;
        this.nClass = 0;
        this.pPoint = 0;
        this.refreshpPoint = 0;
        this.potential = null;
        this.sPoint = 0;
        this.refreshsPoint = 0;
        this.pointNon = 0;
        this.pointVukhi = 0;
        this.pointAo = 0;
        this.pointLien = 0;
        this.pointGangtay = 0;
        this.pointNhan = 0;
        this.pointQuan = 0;
        this.pointNgocboi = 0;
        this.pointGiay = 0;
        this.pointPhu = 0;
        this.nvDV = new short[] { 20, 0, 0, 0, -1 };
        this.ASkill = new ArrayList<Skill>();
        this.aEff = new ArrayList<Effect>();
        this.KSkill = null;
        this.OSkill = null;
        this.CSkill = null;
        this.myskill = null;
        this.ItemBody = new Item[32];
        this.ItemMounts = new Item[5];
        this.isBatNhanban = false;
        this.isToNhanban = false;
        this.timeLiveNhanban = -1;
        this.percentPow = 0;
        this.arrChar = new Char[2];
        this.Nhanban = null;
        this.tileMap = null;
        this.statusMe = 1;
        this.mapId = 22;
        this.mapLTDId = 22;
        this.cx = 1660;
        this.cy = 264;
        this.ItemUseLimit = new ArrayList<Limit>();
        this.timeSelectSkill = -1L;
        this.mobFocus = null;
        this.mobMe = null;
        this.party = null;
        this.aPartyInvite = new ArrayList<Please>();
        this.aPartyInvate = new ArrayList<Please>();
        this.cClanName = "";
        this.ctypeClan = -1;
        this.pointClan = 0;
        this.member = null;
        this.clan = null;
        this.aClanInvite = new ArrayList<Please>();
        this.aClanInvate = new ArrayList<Please>();
        this.countPB = 1;
        this.pointPB = 0;
        this.timeFinishCave = -1;
        this.countPartyPB = 0;
        this.caveId = -1;
        this.partyCaveId = -1;
        this.pointChienTruong = 0;
        this.lastTimeOnline = -1L;
        this.testCharID = -9999;
        this.delaytestCharID = 0;
        this.isTest = false;
        this.KillCharId = -9999;
        this.isCuuSat = false;
        this.testDunCharID = -9999;
        this.delaytestDunCharID = 0;
        this.testDunPhe = -1;
        this.delaythacau = -1;
        this.isLockAttack = false;
        this.isInvisible = false;
        this.isDisable = false;
        this.isDontMove = false;
        this.isFire = false;
        this.isIce = false;
        this.isWind = false;
        this.isBurn = false;
        this.isThuCuoiHetHan = false;
        this.timeBurn = 0;
        this.dXYBurn = 0;
        this.aBurn = new ArrayList<Mob>();
        this.delayEffect = 0;
        this.setThoiTrang = new short[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
        this.LOCK = new Object();
        synchronized (Char.LOCK_LOCAL) {
            this.charID = Char.baseId++;
            this.user = user;
            this.potential = new short[] { 15, 5, 5, 5 };
            this.KSkill = new byte[] { -1, -1, -1 };
            this.OSkill = new byte[] { -1, -1, -1, -1, -1 };
            this.CSkill = new byte[] { -1 };
        }
    }
    
    protected Char findCharInMap(final int charId) {
        if (this.tileMap != null) {
            try {
                for (short i = 0; i < this.tileMap.aCharInMap.size(); ++i) {
                    final Char _char = this.tileMap.aCharInMap.get(i);
                    if (charId == _char.charID) {
                        return _char;
                    }
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    
    protected synchronized void upPk(final int cPk) {
        this.cPk += (byte)cPk;
        if (this.cPk > 15) {
            this.cPk = 15;
        }
        else if (this.cPk < 0) {
            this.cPk = 0;
        }
    }
    
    protected synchronized boolean upHP(final int hp) {
        if (this.statusMe != 14) {
            this.cHP += hp;
            if (this.cHP > this.cMaxHP()) {
                this.cHP = this.cMaxHP();
            }
        }
        return this.statusMe == 14;
    }
    
    protected synchronized void upMP(final int mp) {
        if (this.statusMe != 14) {
            this.cMP += mp;
            if (this.cMP > this.cMaxMP()) {
                this.cMP = this.cMaxMP();
            }
            else if (this.cMP <= 0) {
                this.cMP = 0;
            }
        }
    }
    
    protected short partCaiTrang() {
        if (this.ItemBody[11] != null && this.ItemBody[11].isItemDisguise()) {
            return this.ItemBody[11].template.part;
        }
        return -1;
    }
    
    protected short coat() {
        try {
            if (this.ItemBody[12] != null) {
                return this.ItemBody[12].template.id;
            }
        }
        catch (Exception ex) {}
        return this.leg;
    }
    
    protected short glove() {
        try {
            if (this.ItemBody[13] != null) {
                return this.ItemBody[13].template.id;
            }
        }
        catch (Exception ex) {}
        return this.glove;
    }
    
    protected void writeParam(final Message msg) {
        try {
            msg.writer().writeByte(this.cSpeed());
            msg.writer().writeInt(this.cMaxHP());
            msg.writer().writeInt(this.cMaxMP());
        }
        catch (Exception ex) {}
    }
    
    protected int getPotential(final byte index) {
        int numpotential = this.potential[index] * (100 + this.PramItemTotal(58)) / 100;
        numpotential += this.PramItemTotal(57);
        return numpotential;
    }
    
    protected int cSpeed() {
        return GameScr.getLevelSpeed(this.cLevel) + this.cspeed * (this.PramItemTotal(16) + 100) / 100 + this.PramItemTotal(93);
    }
    
    protected int cMaxHP() {
        int maxhp = this.getPotential((byte)2) * 10 * (this.PramItemTotal(17) + this.PramItemTotal(31) + this.PramItemTotal(61) + this.PramItemTotal(128) + this.PramSkillTotal(17) + 100) / 100;
        maxhp += this.PramItemTotal(6) + this.PramItemTotal(32) + this.PramItemTotal(77) + this.PramItemTotal(82) + this.PramItemTotal(125) + this.cMaxHP;
        synchronized (this.aEff) {
            for (short i = 0; i < this.aEff.size(); ++i) {
                final Effect effect = this.aEff.get(i);
                if (effect != null && effect.template.type == 23) {
                    maxhp += effect.param;
                }
            }
        }
        if (this.cHP > maxhp) {
            this.cHP = maxhp;
        }
        return maxhp;
    }
    
    protected int cMaxMP() {
        int maxmp = this.getPotential((byte)3) * 8 * (this.PramItemTotal(28) + this.PramItemTotal(60) + this.PramSkillTotal(18) + 100) / 100;
        maxmp += this.PramItemTotal(7) + this.PramItemTotal(19) + this.PramItemTotal(29) + this.PramItemTotal(83) + this.PramItemTotal(117) + this.cMaxMP;
        if (this.cMP > maxmp) {
            this.cMP = maxmp;
        }
        return maxmp;
    }
    
    protected int eff5BuffHp() {
        return this.PramItemTotal(30) + this.PramItemTotal(120);
    }
    
    protected int eff5BuffMp() {
        return this.PramItemTotal(27) + this.PramItemTotal(119);
    }
    
    protected int cDame(final byte sys, final int percentdame, final int dameAdd, final int ResFire, final int ResIce, final int ResWind, final int down, final int percentdown, int miss, final boolean flag, final int ResFantal, final int DownFantal) {
        int dame = 0;
        int percent = percentdame + this.PramSkillTotal(11) + this.PramItemTotal(94) + this.dameSysPercent(sys);
        synchronized (this.aEff) {
            for (short i = 0; i < this.aEff.size(); ++i) {
                final Effect effect = this.aEff.get(i);
                if (effect != null) {
                    if (effect.template.type == 13 || effect.template.type == 21) {
                        percent += effect.param;
                    }
                    else if (effect.template.type == 15) {
                        percent += effect.params[1];
                    }
                }
            }
        }
        int fire = this.PramSkillTotal(2) + this.PramItemTotal(88);
        int ice = this.PramSkillTotal(3) + this.PramItemTotal(89);
        int wind = this.PramSkillTotal(4) + this.PramItemTotal(90);
        if (this.myskill != null) {
            if (this.myskill.isSkill30()) {
                percent += this.PramSkillTotal(58);
            }
            else if (this.myskill.isSkill40()) {
                percent += this.PramSkillTotal(59);
            }
            else if (this.myskill.isSkill50()) {
                percent += this.PramSkillTotal(60);
            }
        }
        if (this.s()) {
            dame = this.getPotential((byte)3) * (this.PramSkillTotal(1) + this.PramItemTotal(9) + percent + 100) / 100;
            dame += this.PramItemTotal(1);
            if (this.sys() == 1) {
                fire += this.PramSkillTotal(8) + this.PramItemTotal(22);
            }
            else if (this.sys() == 2) {
                ice += this.PramSkillTotal(9) + this.PramItemTotal(24);
            }
            else if (this.sys() == 3) {
                wind += this.PramSkillTotal(10) + this.PramItemTotal(26);
            }
        }
        else {
            dame = this.getPotential((byte)0) * (this.PramSkillTotal(0) + this.PramItemTotal(8) + percent + 100) / 100;
            dame += this.PramItemTotal(0);
            if (this.sys() == 1) {
                fire += this.PramSkillTotal(5) + this.PramItemTotal(21);
            }
            else if (this.sys() == 2) {
                ice += this.PramSkillTotal(6) + this.PramItemTotal(23);
            }
            else if (this.sys() == 3) {
                ice += this.PramSkillTotal(7) + this.PramItemTotal(25);
            }
        }
        dame = dame + this.PramItemTotal(38) + this.PramItemTotal(73) + this.PramItemTotal(76) + this.PramItemTotal(87) + this.PramItemTotal(94);
        fire -= ((ResFire > 0) ? ResFire : 0);
        ice -= ((ResIce > 0) ? ResIce : 0);
        wind -= ((ResWind > 0) ? ResWind : 0);
        if (fire > 0) {
            dame += fire;
        }
        if (ice > 0) {
            dame += ice;
        }
        if (wind > 0) {
            dame += wind;
        }
        if (flag) {
            dame *= 2;
            final int percentFantal = this.percentFantalDame() - ResFantal;
            if (percentFantal > 0) {
                dame += dame * percentFantal / 100;
            }
            dame += this.PramItemTotal(105);
            dame -= dame * DownFantal / 100;
        }
        dame -= dame * percentdown / 100;
        dame += this.dameAddSys(sys);
        dame -= down;
        if (dame <= 0) {
            dame = 1;
        }
        miss -= this.cExactly();
        if (Util.nextInt(1, Util.nextInt(100, 15000)) < miss) {
            dame = 0;
        }
        return dame;
    }
    
    protected int dameDownPercent() {
        return this.PramItemTotal(63) + this.PramItemTotal(98) + this.PramItemTotal(80);
    }
    
    protected int dameDownSys(final byte sys) {
        if (sys == 1) {
            return this.PramItemTotal(48);
        }
        if (sys == 2) {
            return this.PramItemTotal(49);
        }
        if (sys == 3) {
            return this.PramItemTotal(50);
        }
        return 0;
    }
    
    protected int dameAddSys(final byte sys) {
        if (sys == 1) {
            return this.PramItemTotal(51);
        }
        if (sys == 2) {
            return this.PramItemTotal(52);
        }
        if (sys == 3) {
            return this.PramItemTotal(53);
        }
        return 0;
    }
    
    protected int dameSysPercent(final byte sys) {
        if (sys == 1) {
            return this.PramItemTotal(54);
        }
        if (sys == 2) {
            return this.PramItemTotal(55);
        }
        if (sys == 3) {
            return this.PramItemTotal(56);
        }
        return 0;
    }
    
    protected int ResFire() {
        int res = 0;
        synchronized (this.aEff) {
            for (short i = 0; i < this.aEff.size(); ++i) {
                final Effect effect = this.aEff.get(i);
                if (effect != null) {
                    if (effect.template.type == 15) {
                        res += effect.params[0];
                    }
                    else if (effect.template.type == 22) {
                        res += effect.param;
                    }
                }
            }
        }
        return this.PramItemTotal(20) + this.PramSkillTotal(19) + this.PramItemTotal(2) + this.PramItemTotal(11) + this.PramItemTotal(33) + this.PramItemTotal(70) + this.PramItemTotal(96) + this.PramSkillTotal(20) + res;
    }
    
    public int ResIce() {
        int res = 0;
        synchronized (this.aEff) {
            for (short i = 0; i < this.aEff.size(); ++i) {
                final Effect effect = this.aEff.get(i);
                if (effect != null) {
                    if (effect.template.type == 15) {
                        res += effect.params[0];
                    }
                    else if (effect.template.type == 22) {
                        res += effect.param;
                    }
                }
            }
        }
        return this.PramItemTotal(20) + this.PramSkillTotal(19) + this.PramItemTotal(3) + this.PramItemTotal(12) + this.PramItemTotal(34) + this.PramItemTotal(71) + this.PramItemTotal(95) + this.PramSkillTotal(21) + res;
    }
    
    public int ResWind() {
        int res = 0;
        synchronized (this.aEff) {
            for (short i = 0; i < this.aEff.size(); ++i) {
                final Effect effect = this.aEff.get(i);
                if (effect != null) {
                    if (effect.template.type == 15) {
                        res += effect.params[0];
                    }
                    else if (effect.template.type == 22) {
                        res += effect.param;
                    }
                }
            }
        }
        return this.PramItemTotal(20) + this.PramSkillTotal(19) + this.PramItemTotal(4) + this.PramItemTotal(13) + this.PramItemTotal(35) + this.PramItemTotal(72) + this.PramItemTotal(97) + this.PramSkillTotal(22) + res;
    }
    
    protected int cdameDown() {
        return this.PramItemTotal(47) + this.PramItemTotal(74) + this.PramItemTotal(80) + this.PramItemTotal(124);
    }
    
    protected int cExactly() {
        int exactly = 0;
        synchronized (this.aEff) {
            for (short i = 0; i < this.aEff.size(); ++i) {
                final Effect effect = this.aEff.get(i);
                if (effect != null && effect.template.type == 20) {
                    exactly += effect.param;
                }
            }
        }
        return this.getPotential((byte)1) + this.PramItemTotal(10) + this.PramItemTotal(18) + this.PramItemTotal(75) + this.PramItemTotal(86) + this.PramItemTotal(116) + this.PramSkillTotal(12) + exactly;
    }
    
    public int cMiss() {
        int miss = 0;
        synchronized (this.aEff) {
            for (short i = 0; i < this.aEff.size(); ++i) {
                final Effect effect = this.aEff.get(i);
                if (effect != null && effect.template.type == 7) {
                    miss += effect.param;
                }
            }
        }
        return this.getPotential((byte)1) * 150 / 100 + this.PramItemTotal(5) + this.PramItemTotal(17) + this.PramItemTotal(62) + this.PramItemTotal(68) + this.PramItemTotal(78) + this.PramItemTotal(84) + this.PramItemTotal(115) + this.PramSkillTotal(13) + this.PramSkillTotal(31) + miss;
    }
    
    public int cFatal() {
        return this.PramItemTotal(14) + this.PramItemTotal(37) + this.PramItemTotal(69) + this.PramItemTotal(92) + this.PramItemTotal(114) + this.PramSkillTotal(14);
    }
    
    protected int ResFantalDame() {
        return this.PramItemTotal(79) + this.PramItemTotal(67) + this.PramSkillTotal(65);
    }
    
    protected int percentFantalDame() {
        return this.PramItemTotal(39) + this.PramItemTotal(67) + this.PramSkillTotal(65);
    }
    
    protected int FantalDameDown() {
        return this.PramItemTotal(46);
    }
    
    protected int cReactDame() {
        return this.PramItemTotal(15) + this.PramItemTotal(91) + this.PramItemTotal(126) + this.PramSkillTotal(15);
    }
    
    protected int sysUp() {
        return 0;
    }
    
    protected int sysDown() {
        return 0;
    }
    
    protected int percentUpEXP() {
        return this.PramItemTotal(100) + this.PramSkillTotal(29);
    }
    
    protected int timeFire() {
        int time = 0;
        synchronized (this.aEff) {
            for (short i = 0; i < this.aEff.size(); ++i) {
                final Effect effect = this.aEff.get(i);
                if (effect != null && effect.template.type == 16) {
                    time += effect.params[0];
                }
            }
        }
        if (this.myskill != null) {
            try {
                for (byte j = 0; j < this.myskill.options.length; ++j) {
                    if (this.myskill.options[j].optionTemplate.id == 24 || this.myskill.options[j].optionTemplate.id == 34) {
                        time += SkillOption.timeMaintain(this.myskill.options[j].optionTemplate.id);
                    }
                }
            }
            catch (Exception ex) {}
        }
        return time;
    }
    
    protected int percentFire() {
        return this.PramSkillTotal(24) + this.PramSkillTotal(34);
    }
    
    protected int cFireDownTime() {
        return (int)(Float.parseFloat("0." + this.PramSkillTotal(37)) * 1000.0f);
    }
    
    protected int timeIce() {
        int time = 0;
        synchronized (this.aEff) {
            for (short i = 0; i < this.aEff.size(); ++i) {
                final Effect effect = this.aEff.get(i);
                if (effect != null && effect.template.type == 16) {
                    time += effect.params[1];
                }
            }
        }
        if (this.myskill != null) {
            try {
                for (byte j = 0; j < this.myskill.options.length; ++j) {
                    if (this.myskill.options[j].optionTemplate.id == 25 || this.myskill.options[j].optionTemplate.id == 35) {
                        time += SkillOption.timeMaintain(this.myskill.options[j].optionTemplate.id);
                    }
                }
            }
            catch (Exception ex) {}
        }
        return time;
    }
    
    protected int percentIce() {
        return this.PramSkillTotal(25) + this.PramSkillTotal(35);
    }
    
    protected int cIceDownTime() {
        return (int)(Float.parseFloat("0." + this.PramSkillTotal(38)) * 1000.0f);
    }
    
    protected int timeWind() {
        if (this.myskill != null) {
            try {
                for (byte i = 0; i < this.myskill.options.length; ++i) {
                    if (this.myskill.options[i].optionTemplate.id == 26 || this.myskill.options[i].optionTemplate.id == 36) {
                        return SkillOption.timeMaintain(this.myskill.options[i].optionTemplate.id);
                    }
                }
            }
            catch (Exception ex) {}
        }
        return 0;
    }
    
    protected int percentWind() {
        return this.PramSkillTotal(26) + this.PramSkillTotal(36);
    }
    
    protected int cWindDownTime() {
        return (int)(Float.parseFloat("0." + this.PramSkillTotal(39)) * 1000.0f);
    }
    
    protected int PramItemTotal(final int id) {
        int param = 0;
        try {
            for (byte i = 0; i < this.ItemBody.length; ++i) {
                final Item item = this.ItemBody[i];
                if (item != null) {
                    for (short j = 0; j < item.options.size(); ++j) {
                        final ItemOption option = item.options.get(j);
                        if (option != null) {
                            if ((option.isKhamVuKhi() && !item.isTypeWeapon()) || (option.isKhamTrangBi() && !item.isTypeClothe()) || (option.isTrangSuc() && !item.isTypeAdorn())) {
                                j += 2;
                            }
                            else if (option.optionTemplate.id == id && !Item.isUpgradeHide(option.optionTemplate.id, item.upgrade)) {
                                param += option.param;
                            }
                        }
                    }
                }
            }
            for (byte i = 0; i < this.ItemMounts.length; ++i) {
                final Item item = this.ItemMounts[i];
                if (item != null) {
                    for (short j = 0; j < item.options.size(); ++j) {
                        final ItemOption option = item.options.get(j);
                        if (option.optionTemplate.id == id && !Item.isUpgradeHide(option.optionTemplate.id, item.upgrade)) {
                            param += option.param;
                        }
                    }
                }
            }
        }
        catch (Exception ex) {}
        return param;
    }
    
    protected int PramSkillTotal(final int id) {
        int param = 0;
        try {
            for (short i = 0; i < this.ASkill.size(); ++i) {
                final Skill skill = this.ASkill.get(i);
                if (id == 58 || id == 59 || id == 60 || skill.template.type == 0 || skill.template.type == 2 || skill.template.id == this.CSkill[0]) {
                    for (byte j = 0; j < skill.options.length; ++j) {
                        final SkillOption option = skill.options[j];
                        if (option.optionTemplate.id == id) {
                            param += option.param;
                        }
                    }
                }
            }
        }
        catch (Exception ex) {}
        return param;
    }
    
    protected boolean s() {
        return this.nClass == 2 || this.nClass == 4 || this.nClass == 6;
    }
    
    protected byte sys() {
        if (this.nClass == 1 || this.nClass == 2) {
            return 1;
        }
        if (this.nClass == 3 || this.nClass == 4) {
            return 2;
        }
        if (this.nClass == 5 || this.nClass == 6) {
            return 3;
        }
        return 0;
    }
    
    protected boolean ItemBodyClear(final byte indexUI) {
        try {
            final Item item = this.ItemBody[indexUI];
            if (item != null) {
                ThoiTrang.removeThoiTrang(this, item.template.id);
                this.ItemBody[indexUI] = null;
            }
            Service.ItemBodyClear(this, indexUI);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
    
    protected static void MoveLast(final Char _char, final short cxMoveLast, final short cyMoveLast) {
        final short dx = (short)Math.abs(_char.cx - cxMoveLast);
        final short dy = (short)Math.abs(_char.cy - cyMoveLast);
        int speed = _char.cSpeed() + 1;
        if (_char.ItemMounts[4] != null) {
            speed += 2;
        }
        if ((dx > speed * 7 && dx > 50) || _char.isDontMove || _char.isIce || _char.isWind) {
            Service.restPoint(_char);
        }
        else {
            if (_char.user.session.delayOut < 60000) {
                _char.user.session.setDelayOut(600000, false);
            }
            _char.cx = cxMoveLast;
            if (!_char.tileMap.map.isTestDunMap()) {
                _char.cy = cyMoveLast;
            }
            if (!_char.isHuman && !_char.isNhanban) {
                _char.user.player.cx = _char.cx;
                _char.user.player.cy = _char.cy;
            }
            synchronized (_char.aEff) {
                for (short i = 0; i < _char.aEff.size(); ++i) {
                    final Effect effect = _char.aEff.get(i);
                    if (effect != null && effect.template.id == 16) {
                        removeEffect(_char, effect.template.id);
                        --i;
                    }
                }
            }
            if (_char.mobFocus != null && (Math.abs(_char.cx - _char.mobFocus.x) > 100 || Math.abs(_char.cy - _char.mobFocus.y) > 80)) {
                _char.mobFocus = null;
            }
            try {
                for (int j = 0; j < _char.tileMap.numPlayer; ++j) {
                    if (_char.tileMap.aCharInMap.get(j).user != null && _char.tileMap.aCharInMap.get(j).user.session != null && _char.tileMap.aCharInMap.get(j).charID != _char.charID) {
                        Service.PlayerMove(_char.tileMap.aCharInMap.get(j), _char.charID, _char.cx, _char.cy);
                    }
                }
            }
            catch (Exception ex) {}
            if (_char.isUpdie(cxMoveLast, cyMoveLast)) {
                _char.upDie((byte)0);
            }
            if (_char.isHuman && _char.Nhanban != null && _char.isBatNhanban && (Math.abs(_char.cx - _char.Nhanban.cx) > 60 || Math.abs(_char.cy - _char.Nhanban.cy) > 30)) {
                _char.Nhanban.cx = (short)Util.nextInt(_char.cx - 60, _char.cx + 60);
                _char.Nhanban.cy = _char.cy;
                try {
                    for (int j = 0; j < _char.tileMap.numPlayer; ++j) {
                        if (_char.tileMap.aCharInMap.get(j).user != null && _char.tileMap.aCharInMap.get(j).user.session != null && _char.tileMap.aCharInMap.get(j).charID != _char.Nhanban.charID) {
                            Service.PlayerMove(_char.tileMap.aCharInMap.get(j), _char.Nhanban.charID, _char.Nhanban.cx, _char.Nhanban.cy);
                        }
                    }
                }
                catch (Exception ex2) {}
            }
            _char.cy = _char.tileMap.touchY(_char.cx, _char.cy);
        }
    }
    
    protected static void ChangMap(final Char _char) {
        Waypoint wa = null;
        if (_char.isDontMove || _char.isIce) {
            return;
        }
        final ArrayList<Waypoint> arrMap = new ArrayList<Waypoint>();
        for (byte i = 0; i < _char.tileMap.aVgo.size(); ++i) {
            final Waypoint go = _char.tileMap.aVgo.get(i);
            if (go != null && go.mapGo != null && _char.cx + 100 >= go.minX && _char.cy + 100 >= go.minY && _char.cx <= go.maxX + 100 && _char.cy <= go.maxY + 100) {
                arrMap.add(go);
            }
        }
        if (arrMap.size() > 0) {
            wa = arrMap.get(Util.nextInt(arrMap.size()));
            for (byte j = 0; j < wa.mapGo.template.WmapID.length; ++j) {
                if (wa.mapGo.template.WmapID[j] == _char.mapId) {
                    _char.cx = wa.mapGo.template.WgoX[j];
                    _char.cy = wa.mapGo.template.WgoY[j];
                }
            }
        }
        if (wa != null) {
            boolean isChuaMo = _char.tileMap.map.isBackCaveMap();
            boolean isToiDa = false;
            byte toiDa = -1;
            if (_char.tileMap.map.isBackCaveMap() && _char.tileMap.map.backCave.cave_MapMaxLength.length > _char.tileMap.map.backCave.level && _char.tileMap.map.backCave.maps.length >= _char.tileMap.map.backCave.cave_MapMaxLength[_char.tileMap.map.backCave.level]) {
                for (byte k = 0; k < _char.tileMap.map.backCave.cave_MapMaxLength[_char.tileMap.map.backCave.level]; ++k) {
                    if (_char.tileMap.map.backCave.maps[k].template.mapID == wa.mapGo.template.mapID) {
                        isChuaMo = false;
                        break;
                    }
                }
            }
            else {
                isChuaMo = false;
            }
            final TileMap tile = wa.mapGo.getSlotZone(_char);
            if (_char.tileMap.map.isBackCaveMap() && tile != null) {
                for (byte l = 0; l < _char.tileMap.map.backCave.maps.length; ++l) {
                    if (_char.tileMap.map.backCave.maps[l].template.mapID == wa.mapGo.template.mapID && _char.tileMap.map.backCave.maxPlayer[l] <= tile.numPlayer) {
                        isToiDa = true;
                        toiDa = _char.tileMap.map.backCave.maxPlayer[l];
                        break;
                    }
                }
            }
            if (tile == null) {
                Service.restPoint(_char);
                GameCanvas.startOKDlg(_char.user.session, Text.get(0, 24));
            }
            else if (Task.isLockChangeMap(tile.mapID, _char.ctaskId)) {
                Service.restPoint(_char);
                GameCanvas.startOKDlg(_char.user.session, Text.get(0, 84));
            }
            else if (_char.isThuCuoiHetHan) {
                _char.cx = _char.tileMap.map.template.goX;
                _char.cy = _char.tileMap.map.template.goY;
                Service.restPoint(_char);
                GameCanvas.startOKDlg(_char.user.session, Text.get(0, 181));
            }
            else if (isChuaMo) {
                Service.restPoint(_char);
                GameCanvas.startOKDlg(_char.user.session, Text.get(0, 272));
            }
            else if (isToiDa) {
                Service.restPoint(_char);
                GameCanvas.startOKDlg(_char.user.session, String.format(Text.get(0, 274), toiDa));
            }
            else if (wa.mapGo.isChienTruong() && wa.mapGo.isMapBlack() && _char.cTypePk != 5) {
                Service.restPoint(_char);
                GameCanvas.startOKDlg(_char.user.session, Text.get(0, 331));
            }
            else if (wa.mapGo.isChienTruong() && wa.mapGo.isMapWhite() && _char.cTypePk != 4) {
                Service.restPoint(_char);
                GameCanvas.startOKDlg(_char.user.session, Text.get(0, 331));
            }
            else if (wa.mapGo.isChienTruong() && wa.mapGo.chientruong.level == 0) {
                Service.restPoint(_char);
                GameCanvas.startOKDlg(_char.user.session, ChienTruong.BATDAULUC_CT[wa.mapGo.chientruong.chientruong_type]);
            }
            else if (wa.mapGo.isChienTruong() && wa.mapGo.chientruong.level == 2) {
                Service.restPoint(_char);
                GameCanvas.startOKDlg(_char.user.session, Text.get(0, 344));
            }
            else {
                if (!_char.tileMap.map.isBackCaveMap()) {
                    for (byte l = 0; l < _char.ItemMounts.length; ++l) {
                        final Item item = _char.ItemMounts[l];
                        if (item != null && item.isExpires && item.expires < System.currentTimeMillis()) {
                            _char.isThuCuoiHetHan = true;
                        }
                    }
                }
                _char.tileMap.Exit(_char);
                _char.cx = wa.goX;
                _char.cy = wa.goY;
                tile.Join(_char);
            }
        }
        else {
            _char.cx = _char.tileMap.map.template.goX;
            _char.cy = _char.tileMap.map.template.goY;
            _char.user.session.setDelayOut(10, true);
        }
    }
    
    protected static void selectSkill(final Char _char, final int skillTemplateId) {
        for (byte i = 0; i < _char.ASkill.size(); ++i) {
            final Skill skill = _char.ASkill.get(i);
            if (skill != null && skill.template.id == skillTemplateId) {
                if (skill.template.type != 0) {
                    _char.CSkill[0] = skill.template.id;
                    _char.myskill = skill;
                    break;
                }
                _char.myskill = null;
            }
        }
    }
    
    protected void upDie(final byte type) {
        if (this.isTest) {
            final Char player = this.findCharInMap(this.testCharID);
            if (player != null) {
                if (player.cHP <= 0) {
                    this.endTest(0);
                }
                else {
                    this.endTest(0);
                }
            }
        }
        this.clearCuuSat();
        if (this.statusMe != 14) {
            this.cy = this.tileMap.touchY(this.cx, this.cy);
            if (this.cx < 0 || this.cx >= this.tileMap.pxw || this.cy < 0 || this.cy >= this.tileMap.pxh) {
                this.cx = this.tileMap.map.template.goX;
                this.cy = this.tileMap.map.template.goY;
            }
            this.cHP = 0;
            this.statusMe = 14;
            this.mobFocus = null;
            if (type == 1 || type == 2) {
                final long xpLVALL = GameScr.getMaxEXP(this.cLevel);
                final long xpLV = GameScr.exps[this.cLevel];
                if (this.cPk > 0) {
                    if (this.cEXP > xpLVALL) {
                        this.cExpDown = 0L;
                        this.cEXP -= xpLV * (5 + this.cPk) / 100L;
                        if (this.cEXP < xpLVALL) {
                            this.cExpDown = xpLVALL - this.cEXP;
                            this.cEXP = xpLVALL;
                        }
                    }
                    else {
                        this.cEXP = xpLVALL;
                        this.cExpDown += xpLV * (5 + this.cPk) / 100L;
                        if (this.cExpDown > xpLV * 50L / 100L) {
                            this.cExpDown = xpLV * 50L / 100L;
                        }
                    }
                    this.upPk(-1);
                }
            }
            if (this.isHuman && !this.tileMap.map.isMapLangCo()) {
                if (this.cExpDown > 0L) {
                    Service.MeDieDownEXP(this);
                }
                else {
                    Service.MeDie(this, type);
                }
                for (int i = 0; i < this.tileMap.numPlayer; ++i) {
                    if (this.tileMap.aCharInMap.get(i).user != null && this.tileMap.aCharInMap.get(i).user.session != null && this.tileMap.aCharInMap.get(i).charID != this.charID) {
                        Service.PlayerDie(this.tileMap.aCharInMap.get(i), this);
                    }
                }
            }
            if (this.testDunPhe > -1 && this.tileMap.map.isTestDunMap() && this.tileMap.map.testDun.isFinght) {
                short blacks = 0;
                short whites = 0;
                for (short j = 0; j < this.tileMap.numPlayer; ++j) {
                    final Char player2 = this.tileMap.aCharInMap.get(j);
                    if (player2 != null) {
                        if (player2.testDunPhe == 0 && player2.statusMe != 14) {
                            ++whites;
                        }
                        if (player2.testDunPhe == 1 && player2.statusMe != 14) {
                            ++blacks;
                        }
                    }
                }
                if (whites == 0 && blacks == 0) {
                    this.tileMap.map.testDun.complete((byte)(-1));
                }
                else if (whites > 0 && blacks == 0) {
                    this.tileMap.map.testDun.complete((byte)0);
                }
                else if (whites == 0 && blacks > 0) {
                    this.tileMap.map.testDun.complete((byte)1);
                }
            }
        }
    }
    
    protected synchronized void updateExp(long xp) {
        if (xp != 0L && (this.user == null || this.PramItemTotal(137) == 0)) {
            if (this.cExpDown > 0L) {
                this.cExpDown -= xp;
                if (this.user != null && this.user.session != null) {
                    Service.upExpDown(this, xp);
                }
            }
            else {
                if (xp > 1000000L && this.isHuman && this.Nhanban != null && this.isBatNhanban) {
                    try {
                        for (short i = 0; i < this.ASkill.size(); ++i) {
                            final Skill skill = this.ASkill.get(i);
                            if (skill != null && skill.isCloneSkill() && skill.template.maxPoint > skill.point && Util.nextInt(1000) < 100 / (skill.point * 10)) {
                                this.upPointSkill(skill.template.id, (byte)(-1), (byte)1);
                                Service.ServerMessage(this, String.format(Text.get(0, 311), skill.template.name, skill.point + 1));
                                break;
                            }
                        }
                    }
                    catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                final long xpold = this.cEXP;
                final int lvold = this.cLevel;
                final long xpMaxupLV = GameScr.getMaxEXP(GameScr.max_upLevel + 1);
                this.cExpDown = 0L;
                GameScr.setLevel_Exp(this, this.cEXP += xp, true);
                if (this.cEXP >= xpMaxupLV) {
                    this.cEXP = xpMaxupLV - 1L;
                    this.cLevel = GameScr.max_upLevel;
                    xp = this.cEXP - xpold;
                }
                if (xp > 0L && this.user != null && this.user.session != null) {
                    Service.upExp(this, xp);
                }
                Task.requestLevel(this);
                if (this.cLevel != lvold) {
                    if (this.isHuman) {
                        Top.sortTop(1, this.cName, null, this.cLevel, null);
                    }
                    if (this.nClass != 0) {
                        for (int j = lvold + 1; j <= this.cLevel; ++j) {
                            upPoint(this, (byte)0, GameScr.getMaxpPoint(j));
                            upPoint(this, (byte)1, 1);
                        }
                    }
                    else {
                        for (int j = lvold + 1; j <= this.cLevel; ++j) {
                            upPoint(this, (byte)0, 10);
                        }
                    }
                    if (this.user != null && this.user.session != null) {
                        Service.MELoadLevel(this, this.cEXP);
                    }
                    try {
                        for (int j = 0; j < this.tileMap.numPlayer; ++j) {
                            if (this.tileMap.aCharInMap.get(j).user != null && this.tileMap.aCharInMap.get(j).user.session != null && this.tileMap.aCharInMap.get(j).charID != this.charID) {
                                Service.PlayerLoadLevel(this.tileMap.aCharInMap.get(j), this.charID, this.cHP, this.cMaxHP(), this.cLevel);
                            }
                        }
                    }
                    catch (Exception ex) {}
                }
            }
        }
    }
    
    protected synchronized void uptaskMaint() {
        final TaskTemplate taskTemplate = GameScr.taskTemplates[this.ctaskId];
        ++this.ctaskCount;
        if (this.ctaskCount >= taskTemplate.counts[this.ctaskIndex]) {
            ++this.ctaskIndex;
            this.ctaskCount = 0;
            if (this.ctaskIndex >= taskTemplate.subNames.length) {
                ++this.ctaskId;
                this.ctaskIndex = -1;
                Service.finishTask(this);
            }
            else {
                Service.nextTask(this);
            }
        }
        else {
            Service.updateTask(this);
        }
    }
    
    public synchronized void clearTask() {
        this.ctaskIndex = -1;
        try {
            for (int i = 0; i < this.user.player.ItemBag.length; ++i) {
                if (this.user.player.ItemBag[i] != null && this.user.player.ItemBag[i].isTypeTask()) {
                    this.user.player.ItemBag[i] = null;
                }
            }
        }
        catch (Exception ex) {}
    }
    
    protected boolean isUpdie(final short x, final short y) {
        return this.statusMe != 14 && this.tileMap != null && (x < 0 || y < 0 || x > this.tileMap.pxw || (!this.tileMap.tileTypeAt(x, y - 1, 64) && y >= this.tileMap.pxh - this.tileMap.size));
    }
    
    protected Effect getEffId(final byte effectTemplateId) {
        try {
            synchronized (this.aEff) {
                for (byte i = 0; i < this.aEff.size(); ++i) {
                    final Effect effect = this.aEff.get(i);
                    if (effect.template.id == effectTemplateId) {
                        return this.aEff.get(i);
                    }
                }
            }
        }
        catch (Exception ex) {}
        return null;
    }
    
    protected Effect getEffType(final byte effectTemplateType) {
        try {
            synchronized (this.aEff) {
                for (byte i = 0; i < this.aEff.size(); ++i) {
                    final Effect effect = this.aEff.get(i);
                    if (effect.template.type == effectTemplateType) {
                        return this.aEff.get(i);
                    }
                }
            }
        }
        catch (Exception ex) {}
        return null;
    }
    
    protected static void setEffect(final Char _char, final byte id, final int timeStart, final int timeLength, final short param, final int[] params, final byte type) {
        final EffectTemplate template = Effect.effTemplates[id];
        if (template != null) {
            synchronized (_char.aEff) {
                Effect effect = null;
                for (short i = 0; i < _char.aEff.size(); ++i) {
                    final Effect eff = _char.aEff.get(i);
                    if ((eff.template.type == template.type && eff.type != 2 && type != 2) || (param == 2 && eff.template.id == template.id)) {
                        effect = eff;
                        break;
                    }
                }
                if (effect == null) {
                    effect = new Effect(id, timeStart, timeLength, param);
                    effect.params = params;
                    effect.type = type;
                    _char.aEff.add(effect);
                    Service.MeAddEfect(_char, effect);
                    try {
                        for (short i = 0; i < _char.tileMap.numPlayer; ++i) {
                            if (_char.tileMap.aCharInMap.get(i).user != null && _char.tileMap.aCharInMap.get(i).user.session != null && _char.tileMap.aCharInMap.get(i).charID != _char.charID) {
                                Service.PlayerAddEfect(_char.tileMap.aCharInMap.get(i), _char, effect);
                            }
                        }
                    }
                    catch (Exception ex) {}
                    if (effect.template.type == 1) {
                        _char.isFire = true;
                    }
                    else if (effect.template.type == 2) {
                        _char.cy = _char.tileMap.touchY(_char.cx, _char.cy);
                        _char.isLockAttack = true;
                        _char.isIce = true;
                    }
                    else if (effect.template.type == 3) {
                        _char.cy = _char.tileMap.touchY(_char.cx, _char.cy);
                        _char.isWind = true;
                    }
                    else if (effect.template.type == 5) {
                        _char.isBurn = true;
                    }
                    else if (effect.template.type == 11 || effect.template.type == 12) {
                        _char.isInvisible = true;
                    }
                    else if (effect.template.type == 14) {
                        _char.isDontMove = true;
                    }
                }
                else {
                    effect.template = template;
                    effect.timeStart = timeStart;
                    effect.timeLenght = timeLength;
                    effect.param = param;
                    effect.params = params;
                    effect.type = type;
                    Service.MeEditEfect(_char, effect);
                    try {
                        for (short i = 0; i < _char.tileMap.numPlayer; ++i) {
                            if (_char.tileMap.aCharInMap.get(i).user != null && _char.tileMap.aCharInMap.get(i).user.session != null && _char.tileMap.aCharInMap.get(i).charID != _char.charID) {
                                Service.PlayerEditEfect(_char.tileMap.aCharInMap.get(i), _char.charID, effect);
                            }
                        }
                    }
                    catch (Exception ex2) {}
                }
            }
        }
    }
    
    protected static void removeEffect(final Char _char, final byte id) {
        for (short i = 0; i < _char.aEff.size(); ++i) {
            final Effect effect = _char.aEff.get(i);
            if (effect != null && effect.template.id == id) {
                if (effect.template.type == 1) {
                    _char.isFire = false;
                }
                else if (effect.template.type == 2) {
                    _char.isIce = false;
                    _char.isLockAttack = false;
                }
                else if (effect.template.type == 3) {
                    _char.isWind = false;
                }
                else if (effect.template.type == 5) {
                    synchronized (_char.aBurn) {
                        _char.isBurn = false;
                        _char.aBurn.clear();
                    }
                }
                else if (effect.template.type == 11) {
                    _char.isInvisible = false;
                }
                else if (effect.template.type == 12) {
                    _char.isInvisible = false;
                }
                else if (effect.template.type == 14) {
                    _char.isDontMove = false;
                }
                _char.aEff.remove(i);
                Service.MeRemoveEfect(_char, effect);
                try {
                    for (short k = 0; k < _char.tileMap.aCharInMap.size(); ++k) {
                        if (_char.tileMap.aCharInMap.get(k).user != null && _char.tileMap.aCharInMap.get(k).user.session != null && _char.tileMap.aCharInMap.get(k).charID != _char.charID) {
                            Service.PlayerRemoveEfect(_char.tileMap.aCharInMap.get(k), _char, effect);
                        }
                    }
                }
                catch (Exception e) {}
                break;
            }
        }
    }
    
    protected void endTest(final int num) {
        if (num > 0) {
            this.cHP = num;
        }
        if (this.isTest) {
            try {
                for (short i = 0; i < this.tileMap.numPlayer; ++i) {
                    if (this.tileMap.aCharInMap.get(i).user != null && this.tileMap.aCharInMap.get(i).user.session != null) {
                        Service.TestEnd(this.tileMap.aCharInMap.get(i), this.charID, this.testCharID, num);
                    }
                }
            }
            catch (Exception ex) {}
        }
        final Char player = this.findCharInMap(this.testCharID);
        if (player != null) {
            player.testCharID = -9999;
            player.isTest = false;
        }
        this.testCharID = -9999;
        this.isTest = false;
    }
    
    protected void clearCuuSat() {
        if (this.KillCharId != -9999) {
            Service.ClearCuuSat(this, this.charID);
            final Char player = this.findCharInMap(this.KillCharId);
            if (player != null) {
                Service.ClearCuuSat(player, this.charID);
            }
        }
        try {
            for (short i = 0; i < this.tileMap.numPlayer; ++i) {
                final Char player2 = this.tileMap.aCharInMap.get(i);
                if (player2 != null && player2.user != null && player2.user.session != null) {
                    if (player2.KillCharId == this.charID) {
                        player2.KillCharId = -9999;
                    }
                    Service.ClearCuuSat(player2, player2.charID);
                }
            }
        }
        catch (Exception ex) {}
        this.KillCharId = -9999;
    }
    
    protected Skill getSkill(final short SkillTemplteId) {
        try {
            for (byte i = 0; i < this.ASkill.size(); ++i) {
                final Skill skill = this.ASkill.get(i);
                if (skill != null && skill.template.id == SkillTemplteId) {
                    return skill;
                }
            }
        }
        catch (Exception ex) {}
        return null;
    }
    
    protected void upPointSkill(final short skillTemplateId, final byte indexUI, final byte pointadd) {
        try {
            if (indexUI == -1) {
                for (byte i = 0; i < this.ASkill.size(); ++i) {
                    final Skill skill = this.ASkill.get(i);
                    if (skill != null && skill.template.id == skillTemplateId) {
                        this.cHP = this.cMaxHP();
                        this.cMP = this.cMaxMP();
                        this.ASkill.set(i, GameScr.skillTemplates[skillTemplateId].skills[skill.point + pointadd].clone());
                        Service.MELoadSkill(this);
                        break;
                    }
                }
            }
            else {
                final Skill skill2 = GameScr.skillTemplates[skillTemplateId].skills[pointadd].clone();
                this.ASkill.add(skill2);
                Service.useBookSkill(this, indexUI, skill2.skillId);
                Service.viewInfo(this, this);
            }
            if (this.ctaskId == 9 && this.ctaskIndex == 1) {
                this.uptaskMaint();
            }
            try {
                for (int j = 0; j < this.tileMap.numPlayer; ++j) {
                    if (this.tileMap.aCharInMap.get(j).user != null && this.tileMap.aCharInMap.get(j).user.session != null && this.charID != this.tileMap.aCharInMap.get(j).charID) {
                        Service.PlayerLoadAll(this.tileMap.aCharInMap.get(j), this);
                    }
                }
            }
            catch (Exception ex) {}
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    protected Please findPartyInvite(final int charId) {
        for (int i = this.aPartyInvite.size() - 1; i >= 0; --i) {
            final Please Invite = this.aPartyInvite.get(i);
            if (Invite.charID == charId) {
                return Invite;
            }
        }
        return null;
    }
    
    protected void removePartyInvite(final int charId) {
        for (int i = this.aPartyInvite.size() - 1; i >= 0; --i) {
            final Please Invite = this.aPartyInvite.get(i);
            if (Invite.charID == charId) {
                this.aPartyInvite.remove(i);
                return;
            }
        }
    }
    
    protected Please findPartyInvate(final int charId) {
        for (int i = this.aPartyInvate.size() - 1; i >= 0; --i) {
            final Please Invate = this.aPartyInvate.get(i);
            if (Invate.charID == charId) {
                return Invate;
            }
        }
        return null;
    }
    
    protected void removePartyInvate(final int charId) {
        for (int i = this.aPartyInvate.size() - 1; i >= 0; --i) {
            final Please Invate = this.aPartyInvate.get(i);
            if (Invate.charID == charId) {
                this.aPartyInvate.remove(i);
                return;
            }
        }
    }
    
    protected Please findClanInvite(final int charId) {
        for (int i = this.aClanInvite.size() - 1; i >= 0; --i) {
            final Please Invite = this.aClanInvite.get(i);
            if (Invite.charID == charId) {
                return Invite;
            }
        }
        return null;
    }
    
    protected void removeClanInvite(final int charId) {
        for (int i = this.aClanInvite.size() - 1; i >= 0; --i) {
            final Please Invite = this.aClanInvite.get(i);
            if (Invite.charID == charId) {
                this.aClanInvite.remove(i);
                return;
            }
        }
    }
    
    protected Please findClanInvate(final int charId) {
        for (int i = this.aClanInvate.size() - 1; i >= 0; --i) {
            final Please Invate = this.aClanInvate.get(i);
            if (Invate.charID == charId) {
                return Invate;
            }
        }
        return null;
    }
    
    protected void removeClanInvate(final int charId) {
        for (int i = this.aClanInvate.size() - 1; i >= 0; --i) {
            final Please Invate = this.aClanInvate.get(i);
            if (Invate.charID == charId) {
                this.aClanInvate.remove(i);
                return;
            }
        }
    }
    
    protected byte full_Ngoc() {
        byte ngocCap = 0;
        boolean ad = false;
        for (byte i = 0; i < 10; ++i) {
            byte upgrade2 = 0;
            final Item item = this.ItemBody[i];
            if (item == null) {
                return 0;
            }
            for (short j = 0; j < item.options.size(); ++j) {
                final ItemOption option = item.options.get(j);
                if (option != null && option.optionTemplate.id >= 109 && option.optionTemplate.id <= 112 && upgrade2 < option.param) {
                    upgrade2 = (byte)option.param;
                }
            }
            if (!ad) {
                ngocCap = upgrade2;
                ad = true;
            }
            if (ngocCap > upgrade2) {
                ngocCap = upgrade2;
            }
        }
        return ngocCap;
    }
    
    protected static void upPoint(final Char _char, final byte type, final int point) {
        if (type == 0) {
            if (_char.nClass != 0) {
                _char.pPoint += (short)point;
            }
            else {
                final short[] potential = _char.potential;
                final int n = 0;
                potential[n] += (short)(point / 2);
                final short[] potential2 = _char.potential;
                final int n2 = 1;
                potential2[n2] += (short)(point / 5);
                final short[] potential3 = _char.potential;
                final int n3 = 2;
                potential3[n3] += (short)(point / 5);
                final short[] potential4 = _char.potential;
                final int n4 = 3;
                potential4[n4] += (short)(point / 5);
            }
            if (_char.user != null && _char.user.session != null) {
                Service.potentialUp(_char);
            }
        }
        else if (type == 1) {
            _char.sPoint += (short)point;
            if (_char.user != null && _char.user.session != null) {
                Service.MELoadSkill(_char);
                Service.viewInfo(_char, _char);
            }
        }
    }
    
    protected static void clearPoint(final Char _char, final byte type, final byte npcTemplateId) {
        if (_char.nClass != 0) {
            if ((_char.nClass == 1 || _char.nClass == 2) && npcTemplateId != 9) {
                Service.openUISay(_char, npcTemplateId, Text.get(0, 119));
            }
            else if ((_char.nClass == 3 || _char.nClass == 4) && npcTemplateId != 10) {
                Service.openUISay(_char, npcTemplateId, Text.get(0, 119));
            }
            else if ((_char.nClass == 5 || _char.nClass == 6) && npcTemplateId != 11) {
                Service.openUISay(_char, npcTemplateId, Text.get(0, 119));
            }
            else if (type == 0) {
                if (_char.refreshpPoint <= 0) {
                    Service.openUISay(_char, npcTemplateId, Text.get(0, 120));
                }
                else {
                    --_char.refreshpPoint;
                    int pointAll = _char.pPoint;
                    for (byte i = 0; i < _char.potential.length; ++i) {
                        pointAll += _char.potential[i];
                    }
                    _char.pPoint = (short)(pointAll - 30);
                    for (byte i = 0; i < _char.potential.length; ++i) {
                        _char.potential[i] = GameScr.resetpPoint(_char.nClass, i);
                    }
                    _char.cHP = _char.cMaxHP();
                    _char.cMP = _char.cMaxMP();
                    Service.potentialUp(_char);
                    try {
                        for (int j = 0; j < _char.tileMap.numPlayer; ++j) {
                            if (_char.tileMap.aCharInMap.get(j).user != null && _char.tileMap.aCharInMap.get(j).user.session != null && _char.charID != _char.tileMap.aCharInMap.get(j).charID) {
                                Service.PlayerLoadAll(_char.tileMap.aCharInMap.get(j), _char);
                            }
                        }
                    }
                    catch (Exception ex) {}
                    GameCanvas.callEffect(_char, (short)21);
                    Service.openUISay(_char, npcTemplateId, Text.get(0, 122));
                }
            }
            else if (type == 1) {
                if (_char.refreshsPoint <= 0) {
                    Service.openUISay(_char, npcTemplateId, Text.get(0, 121));
                }
                else {
                    --_char.refreshsPoint;
                    short pointAll2 = _char.sPoint;
                    for (short k = 0; k < _char.ASkill.size(); ++k) {
                        final Skill skill = _char.ASkill.get(k);
                        if (skill != null && skill.point > 0 && skill.template.skills.length > 1 && !skill.isCloneSkill()) {
                            pointAll2 += (short)(skill.point - 1);
                            _char.ASkill.set(k, skill.template.skills[1].clone());
                        }
                    }
                    _char.sPoint = pointAll2;
                    Service.MELoadSkill(_char);
                    Service.viewInfo(_char, _char);
                    try {
                        for (int j = 0; j < _char.tileMap.numPlayer; ++j) {
                            if (_char.tileMap.aCharInMap.get(j).user != null && _char.tileMap.aCharInMap.get(j).user.session != null && _char.charID != _char.tileMap.aCharInMap.get(j).charID) {
                                Service.PlayerLoadAll(_char.tileMap.aCharInMap.get(j), _char);
                            }
                        }
                    }
                    catch (Exception ex2) {}
                    GameCanvas.callEffect(_char, (short)21);
                    Service.openUISay(_char, npcTemplateId, Text.get(0, 123));
                }
            }
        }
    }
    
    protected static void upPointClan(final Char _char, final int point) {
        if (_char.clan != null) {
            final Clan clan = _char.clan;
            synchronized (clan.LOCK_CLAN) {
                for (short i = 0; i < clan.members.size(); ++i) {
                    final Member mem = clan.members.get(i);
                    if (mem != null && mem.cName.equals(_char.cName)) {
                        final Member member = mem;
                        final Member member2 = _char.member;
                        final int pointClan = _char.pointClan + point;
                        _char.pointClan = pointClan;
                        member2.pointClan = pointClan;
                        member.pointClan = pointClan;
                        final Member member3 = _char.member;
                        final Member member4 = mem;
                        final int n = member4.pointClanWeek + point;
                        member4.pointClanWeek = n;
                        member3.pointClanWeek = n;
                        clan.updateExp(point);
                        Service.ServerMessage(_char, String.format(Text.get(0, 225), point));
                        break;
                    }
                }
            }
        }
    }
    
    protected boolean isNotPK() {
        for (byte i = 0; i < this.ItemBody.length; ++i) {
            final Item item = this.ItemBody[i];
            if (item != null && item.isItemResPk()) {
                return true;
            }
        }
        return false;
    }
    
    protected void upPointChientruong(short pointAdd) {
        if (this.tileMap.map.isChienTruong() && this.tileMap.map.chientruong.level == 1) {
            if (this.pointChienTruong + pointAdd > 32767) {
                pointAdd = 0;
            }
            this.pointChienTruong += pointAdd;
            if (this.pointChienTruong > 30000) {
                this.pointChienTruong = 30000;
            }
            else {
                Top.sortTop(5, this.cName, ChienTruong.TITLE_CT[this.getCT()], this.pointChienTruong, new int[] { (this.cTypePk == 4) ? 0 : ((this.cTypePk == 5) ? 1 : -1) });
                if (this.tileMap.map.chientruong.aCharBlack.contains(this.user.player.playerId)) {
                    final ChienTruong chientruong = this.tileMap.map.chientruong;
                    chientruong.totalBlack += pointAdd;
                }
                else if (this.tileMap.map.chientruong.aCharWhite.contains(this.user.player.playerId)) {
                    final ChienTruong chientruong2 = this.tileMap.map.chientruong;
                    chientruong2.totalWhite += pointAdd;
                }
            }
            Service.pointChienTruong(this, this.pointChienTruong);
        }
    }
    
    protected int getCT() {
        if (this.pointChienTruong >= 4000) {
            return 4;
        }
        if (this.pointChienTruong >= 1500) {
            return 3;
        }
        if (this.pointChienTruong >= 600) {
            return 2;
        }
        if (this.pointChienTruong >= 200) {
            return 1;
        }
        return 0;
    }
    
    protected void nextNVDV() {
        if (this.nvDV[4] != -1 && this.nvDV[2] < this.nvDV[3]) {
            byte i = 0;
            while (i < this.ItemBody.length) {
                if (this.ItemBody[i] != null && this.ItemBody[i].template.id == this.nvDV[4]) {
                    final short[] nvDV = this.nvDV;
                    final int n = 2;
                    ++nvDV[n];
                    Service.ServerMessage(this, String.format(Text.get(0, 379), GameScr.itemTemplates[this.nvDV[4]].name, String.format(DanhVong.DESC_NV[this.nvDV[1]], this.nvDV[2], this.nvDV[3])));
                    if (this.nvDV[2] >= this.nvDV[3]) {
                        Service.ServerMessage(this, Text.get(0, 366));
                        break;
                    }
                    break;
                }
                else {
                    ++i;
                }
            }
        }
    }
    
    protected byte getEffDeNhat() {
        final int type = 4;
        final int nTop = Top.getTop(this.cName, type);
        byte idEff = -1;
        if (nTop > 0 && nTop < 4) {
            if (this.nClass == 1) {
                idEff = 16;
            }
            if (this.nClass == 2) {
                idEff = 17;
            }
            if (this.nClass == 3) {
                idEff = 15;
            }
            if (this.nClass == 4) {
                idEff = 13;
            }
            if (this.nClass == 1) {
                idEff = 12;
            }
            if (this.nClass == 1) {
                idEff = 14;
            }
        }
        return idEff;
    }
    
    static {
        Char.baseId = 10000;
        LOCK_LOCAL = new Object();
    }
}
