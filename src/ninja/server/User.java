
package ninja.server;

import org.json.simple.parser.ParseException;
import ninja.option.ItemOption;
import java.sql.SQLException;
import java.sql.ResultSet;
import org.json.simple.JSONValue;
import org.json.simple.JSONArray;
import io.MySQL;

public class User
{
    protected final Object LOCK;
    protected Session_ME session;
    protected int userId;
    protected String userName;
    protected int luong;
    protected Player[] players;
    protected Player player;
    protected byte numPlayer;
    protected long secondKTG;
    
    private User(final Session_ME session) {
        this.LOCK = new Object();
        this.luong = 0;
        this.player = null;
        this.numPlayer = 0;
        this.secondKTG = 0L;
        this.session = session;
        this.players = new Player[GameScr.max_CreateChar];
    }
    
    protected static Player selectCharToPlay(final User user, final String name) {
        for (byte i = 0; i < user.players.length; ++i) {
            final Player _char = user.players[i];
            if (_char != null && _char.cName.equals(name)) {
                user.player = _char;
                user.players[i] = user.players[0];
                return user.players[0] = _char;
            }
        }
        return null;
    }
    
    protected static User Login(final Session_ME session, final String uname, final String pass) {
        User user = null;
        try {
            final MySQL mySQL = new MySQL(1);
            try {
                ResultSet red = mySQL.stat.executeQuery("SELECT * FROM `user` WHERE (`user` LIKE '" + Util.strSQL(uname) + "' AND `password` LIKE '" + Util.strSQL(pass) + "') LIMIT 1;");
                if (red.first()) {
                    final int uId = red.getInt("userId");
                    final boolean lock = red.getBoolean("lock");
                    final boolean online = red.getBoolean("online");
                    final int luong = red.getInt("luong");
                    final byte status = red.getByte("status");
                    if (status == 0) {
                        GameCanvas.startOKDlg(session, Text.get(0, 308));
                        return null;
                    }
                    final JSONArray jrs = (JSONArray)JSONValue.parseWithException(red.getString("player"));
                    if (lock) {
                        GameCanvas.startOKDlg(session, Text.get(0, 1));
                        return null;
                    }
                    user = Client.getUser(uname);
                    if (user != null) {
                        GameCanvas.startOKDlg(user.session, Text.get(0, 2));
                        user.FLUSH();
                        user.session.disconnect();
                        GameCanvas.startOKDlg(session, Text.get(0, 3));
                        return null;
                    }
                    user = new User(session);
                    user.userId = uId;
                    user.userName = uname;
                    user.luong = luong;
                    for (byte i = 0; i < jrs.size(); ++i) {
                        red = mySQL.stat.executeQuery("SELECT * FROM `player` WHERE `playerId`=" + Integer.parseInt(jrs.get((int)i).toString()) + " LIMIT 1;");
                        red.first();
                        final Player _char = new Player(user);
                        _char.playerId = red.getInt("playerId");
                        _char.cloneId = red.getInt("cloneId");
                        _char.ctaskId = red.getByte("ctaskId");
                        _char.ctaskIndex = red.getByte("ctaskIndex");
                        _char.ctaskCount = red.getShort("ctaskCount");
                        _char.cgender = red.getByte("cgender");
                        _char.head = red.getShort("head");
                        _char.cspeed = red.getByte("cspeed");
                        _char.cName = red.getString("cName");
                        _char.cPk = red.getByte("cPk");
                        _char.cEXP = red.getLong("cEXP");
                        _char.cExpDown = red.getLong("cExpDown");
                        _char.cLevel = red.getInt("cLevel");
                        _char.nClass = red.getByte("nClass");
                        _char.pPoint = red.getShort("pPoint");
                        _char.refreshpPoint = red.getByte("refreshpPoint");
                        JSONArray jarr2 = (JSONArray)JSONValue.parseWithException(red.getString("potential"));
                        for (byte j = 0; j < jarr2.size(); ++j) {
                            _char.potential[j] = Short.parseShort(jarr2.get((int)j).toString());
                        }
                        _char.sPoint = red.getShort("sPoint");
                        _char.refreshsPoint = red.getByte("refreshsPoint");
                        _char.xu = red.getInt("xu");
                        _char.xuBox = red.getInt("xuBox");
                        _char.yen = red.getInt("yen");
                        jarr2 = (JSONArray)JSONValue.parseWithException(red.getString("vFriend"));
                        for (short k = 0; k < jarr2.size(); ++k) {
                            final JSONArray jarr3 = (JSONArray)jarr2.get((int)k);
                            final Friend friend = new Friend(jarr3.get(0).toString(), Byte.parseByte(jarr3.get(1).toString()));
                            _char.vFriend.add(friend);
                        }
                        jarr2 = (JSONArray)JSONValue.parseWithException(red.getString("VSkill"));
                        for (byte j = 0; j < jarr2.size(); ++j) {
                            final JSONArray jarr3 = (JSONArray)jarr2.get((int)j);
                            final Skill skill = GameScr.skillTemplates[Byte.parseByte(jarr3.get(0).toString())].skills[Short.parseShort(jarr3.get(1).toString())].clone();
                            if (_char.myskill == null) {
                                _char.myskill = skill;
                            }
                            _char.ASkill.add(skill);
                        }
                        jarr2 = (JSONArray)JSONValue.parseWithException(red.getString("vEff"));
                        for (byte j = 0; j < jarr2.size(); ++j) {
                            final JSONArray jarr3 = (JSONArray)jarr2.get((int)j);
                            final Effect effect = new Effect();
                            effect.template = Effect.effTemplates[Byte.parseByte(jarr3.get(0).toString())];
                            effect.timeStart = Integer.parseInt(jarr3.get(1).toString());
                            effect.timeLenght = Integer.parseInt(jarr3.get(2).toString());
                            effect.param = Short.parseShort(jarr3.get(3).toString());
                            effect.type = Byte.parseByte(jarr3.get(4).toString());
                            _char.aEff.add(effect);
                        }
                        jarr2 = (JSONArray)JSONValue.parseWithException(red.getString("KSkill"));
                        for (byte j = 0; j < jarr2.size(); ++j) {
                            _char.KSkill[j] = Byte.parseByte(jarr2.get((int)j).toString());
                        }
                        jarr2 = (JSONArray)JSONValue.parseWithException(red.getString("OSkill"));
                        for (byte j = 0; j < jarr2.size(); ++j) {
                            _char.OSkill[j] = Byte.parseByte(jarr2.get((int)j).toString());
                        }
                        jarr2 = (JSONArray)JSONValue.parseWithException(red.getString("CSkill"));
                        for (byte j = 0; j < jarr2.size(); ++j) {
                            _char.CSkill[j] = Byte.parseByte(jarr2.get((int)j).toString());
                        }
                        if (_char.CSkill[0] != -1) {
                            _char.myskill = _char.getSkill(_char.CSkill[0]);
                        }
                        _char.bagCount = red.getByte("bagCount");
                        jarr2 = (JSONArray)JSONValue.parseWithException(red.getString("bagOpen"));
                        for (short k = 0; k < jarr2.size(); ++k) {
                            _char.bagOpen.add(Short.parseShort(jarr2.get((int)k).toString()));
                        }
                        _char.ItemBag = new Item[_char.bagCount];
                        jarr2 = (JSONArray)JSONValue.parseWithException(red.getString("ItemBag"));
                        if (jarr2 != null) {
                            for (short k = 0; k < jarr2.size(); ++k) {
                                final Item item = Item.parseItem(jarr2.get((int)k).toString());
                                item.typeUI = 3;
                                _char.ItemBag[item.indexUI] = item;
                            }
                        }
                        _char.ItemBox = new Item[30];
                        jarr2 = (JSONArray)JSONValue.parseWithException(red.getString("ItemBox"));
                        if (jarr2 != null) {
                            for (short k = 0; k < jarr2.size(); ++k) {
                                final Item item = Item.parseItem(jarr2.get((int)k).toString());
                                item.typeUI = 4;
                                _char.ItemBox[item.indexUI] = item;
                            }
                        }
                        jarr2 = (JSONArray)JSONValue.parseWithException(red.getString("ItemBody"));
                        if (jarr2 != null) {
                            for (short k = 0; k < jarr2.size(); ++k) {
                                final Item item = Item.parseItem(jarr2.get((int)k).toString());
                                item.typeUI = 5;
                                _char.ItemBody[item.indexUI] = item;
                                ThoiTrang.setThoiTrang(_char, item.template.id);
                            }
                        }
                        jarr2 = (JSONArray)JSONValue.parseWithException(red.getString("ItemMounts"));
                        if (jarr2 != null) {
                            for (short k = 0; k < jarr2.size(); ++k) {
                                final Item item = Item.parseItem(jarr2.get((int)k).toString());
                                item.typeUI = 41;
                                _char.ItemMounts[item.indexUI] = item;
                                ThoiTrang.setThoiTrang(_char, item.template.id);
                            }
                        }
                        jarr2 = (JSONArray)JSONValue.parseWithException(red.getString("LevelGift"));
                        for (short k = 0; k < jarr2.size(); ++k) {
                            _char.LevelGift.add(Integer.parseInt(jarr2.get((int)k).toString()));
                        }
                        jarr2 = (JSONArray)JSONValue.parseWithException(red.getString("ItemUseLimit"));
                        for (short k = 0; k < jarr2.size(); ++k) {
                            final JSONArray jarr3 = (JSONArray)jarr2.get((int)k);
                            final Limit limit = new Limit(Short.parseShort(jarr3.get(0).toString()), Integer.parseInt(jarr3.get(1).toString()), Byte.parseByte(jarr3.get(2).toString()) != 0);
                            _char.ItemUseLimit.add(limit);
                        }
                        _char.epoint = red.getInt("epoint");
                        jarr2 = (JSONArray)JSONValue.parseWithException(red.getString("InfoMap"));
                        _char.statusMe = Byte.parseByte(jarr2.get(0).toString());
                        _char.mapId = Integer.parseInt(jarr2.get(1).toString());
                        _char.mapLTDId = Integer.parseInt(jarr2.get(2).toString());
                        _char.cx = Short.parseShort(jarr2.get(3).toString());
                        _char.cy = Short.parseShort(jarr2.get(4).toString());
                        _char.cClanName = red.getString("cClanName");
                        final Player player = _char;
                        final int playerId = _char.playerId;
                        final String cName = _char.cName;
                        final byte nClass = _char.nClass;
                        final int cLevel = _char.cLevel;
                        final Player player2 = _char;
                        final int int1 = red.getInt("pointClan");
                        player2.pointClan = int1;
                        player.member = new Member(playerId, cName, nClass, cLevel, int1);
                        if (!_char.cClanName.isEmpty()) {
                            final Clan clan = Clan.get(_char.cClanName);
                            if (clan != null) {
                                final Member mem = Clan.getMem(clan, _char.cName);
                                if (mem != null) {
                                    final Player player3 = _char;
                                    final Member member = _char.member;
                                    final byte typeClan = mem.typeClan;
                                    member.typeClan = typeClan;
                                    player3.ctypeClan = typeClan;
                                    _char.member.pointClanWeek = mem.pointClanWeek;
                                    mem.nClass = _char.nClass;
                                    mem.cLevel = _char.cLevel;
                                    mem.pointClan = _char.pointClan;
                                    _char.clan = clan;
                                }
                                else {
                                    _char.cClanName = "";
                                }
                            }
                            else {
                                _char.cClanName = "";
                            }
                        }
                        _char.countPB = red.getByte("countPB");
                        _char.pointPB = red.getShort("pointPB");
                        _char.countPB = red.getByte("countPB");
                        _char.timeFinishCave = red.getInt("timeFinishCave");
                        _char.countPartyPB = red.getByte("countPartyPB");
                        _char.caveId = red.getInt("caveId");
                        _char.pointChienTruong = red.getShort("pointChienTruong");
                        _char.lastTimeOnline = red.getLong("lastTimeOnline");
                        _char.pointNon = red.getShort("pointNon");
                        _char.pointVukhi = red.getShort("pointVukhi");
                        _char.pointAo = red.getShort("pointAo");
                        _char.pointLien = red.getShort("pointLien");
                        _char.pointGangtay = red.getShort("pointGangtay");
                        _char.pointNhan = red.getShort("pointNhan");
                        _char.pointQuan = red.getShort("pointQuan");
                        _char.pointNgocboi = red.getShort("pointNgocboi");
                        _char.pointGiay = red.getShort("pointGiay");
                        _char.pointPhu = red.getShort("pointPhu");
                        final JSONArray nvDV = (JSONArray)JSONValue.parseWithException(red.getString("nvDV"));
                        for (byte l = 0; l < _char.nvDV.length; ++l) {
                            _char.nvDV[l] = Short.parseShort(nvDV.get((int)l).toString());
                        }
                        _char.cHP = _char.cMaxHP();
                        _char.cMP = _char.cMaxMP();
                        _char.isNhanban = false;
                        _char.isHuman = true;
                        if (_char.cloneId != -1) {
                            red = mySQL.stat.executeQuery("SELECT * FROM `clone` WHERE `playerId`=" + _char.cloneId + " LIMIT 1;");
                            if (red.first()) {
                                final Char clone = new Char(null);
                                clone.playerId = red.getInt("playerId");
                                clone.cgender = red.getByte("cgender");
                                clone.head = red.getShort("head");
                                clone.cspeed = red.getByte("cspeed");
                                clone.cName = red.getString("cName");
                                clone.cEXP = red.getLong("cEXP");
                                clone.cExpDown = red.getLong("cExpDown");
                                clone.cLevel = red.getInt("cLevel");
                                clone.nClass = red.getByte("nClass");
                                clone.pPoint = red.getShort("pPoint");
                                clone.refreshpPoint = red.getByte("refreshpPoint");
                                jarr2 = (JSONArray)JSONValue.parseWithException(red.getString("potential"));
                                for (byte m = 0; m < jarr2.size(); ++m) {
                                    clone.potential[m] = Short.parseShort(jarr2.get((int)m).toString());
                                }
                                clone.sPoint = red.getShort("sPoint");
                                clone.refreshsPoint = red.getByte("refreshsPoint");
                                jarr2 = (JSONArray)JSONValue.parseWithException(red.getString("VSkill"));
                                for (byte m = 0; m < jarr2.size(); ++m) {
                                    final JSONArray jarr4 = (JSONArray)jarr2.get((int)m);
                                    final Skill skill2 = GameScr.skillTemplates[Byte.parseByte(jarr4.get(0).toString())].skills[Short.parseShort(jarr4.get(1).toString())].clone();
                                    if (clone.myskill == null) {
                                        clone.myskill = skill2;
                                    }
                                    clone.ASkill.add(skill2);
                                }
                                jarr2 = (JSONArray)JSONValue.parseWithException(red.getString("vEff"));
                                for (byte m = 0; m < jarr2.size(); ++m) {
                                    final JSONArray jarr4 = (JSONArray)jarr2.get((int)m);
                                    final Effect effect2 = new Effect();
                                    effect2.template = Effect.effTemplates[Byte.parseByte(jarr4.get(0).toString())];
                                    effect2.timeStart = Integer.parseInt(jarr4.get(1).toString());
                                    effect2.timeLenght = Integer.parseInt(jarr4.get(2).toString());
                                    effect2.param = Short.parseShort(jarr4.get(3).toString());
                                    effect2.type = Byte.parseByte(jarr4.get(4).toString());
                                    clone.aEff.add(effect2);
                                }
                                jarr2 = (JSONArray)JSONValue.parseWithException(red.getString("KSkill"));
                                for (byte m = 0; m < jarr2.size(); ++m) {
                                    clone.KSkill[m] = Byte.parseByte(jarr2.get((int)m).toString());
                                }
                                jarr2 = (JSONArray)JSONValue.parseWithException(red.getString("OSkill"));
                                for (byte m = 0; m < jarr2.size(); ++m) {
                                    clone.OSkill[m] = Byte.parseByte(jarr2.get((int)m).toString());
                                }
                                jarr2 = (JSONArray)JSONValue.parseWithException(red.getString("CSkill"));
                                for (byte m = 0; m < jarr2.size(); ++m) {
                                    clone.CSkill[m] = Byte.parseByte(jarr2.get((int)m).toString());
                                }
                                if (clone.CSkill[0] != -1) {
                                    clone.myskill = clone.getSkill(clone.CSkill[0]);
                                }
                                jarr2 = (JSONArray)JSONValue.parseWithException(red.getString("ItemBody"));
                                if (jarr2 != null) {
                                    for (short j2 = 0; j2 < jarr2.size(); ++j2) {
                                        final Item item2 = Item.parseItem(jarr2.get((int)j2).toString());
                                        item2.typeUI = 5;
                                        clone.ItemBody[item2.indexUI] = item2;
                                        ThoiTrang.setThoiTrang(clone, item2.template.id);
                                    }
                                }
                                jarr2 = (JSONArray)JSONValue.parseWithException(red.getString("ItemMounts"));
                                if (jarr2 != null) {
                                    for (short j2 = 0; j2 < jarr2.size(); ++j2) {
                                        final Item item2 = Item.parseItem(jarr2.get((int)j2).toString());
                                        item2.typeUI = 41;
                                        clone.ItemMounts[item2.indexUI] = item2;
                                        ThoiTrang.setThoiTrang(clone, item2.template.id);
                                    }
                                }
                                jarr2 = (JSONArray)JSONValue.parseWithException(red.getString("ItemUseLimit"));
                                for (short j2 = 0; j2 < jarr2.size(); ++j2) {
                                    final JSONArray jarr4 = (JSONArray)jarr2.get((int)j2);
                                    final Limit limit2 = new Limit(Short.parseShort(jarr4.get(0).toString()), Integer.parseInt(jarr4.get(1).toString()), Byte.parseByte(jarr4.get(2).toString()) != 0);
                                    clone.ItemUseLimit.add(limit2);
                                }
                                clone.timeLiveNhanban = red.getInt("timeLive");
                                clone.cHP = _char.cMaxHP();
                                clone.cMP = _char.cMaxMP();
                                clone.isNhanban = true;
                                clone.isHuman = false;
                                _char.Nhanban = clone;
                            }
                            else {
                                _char.cloneId = -1;
                            }
                        }
                        user.players[i] = _char;
                        final User user2 = user;
                        ++user2.numPlayer;
                    }
                    mySQL.stat.executeUpdate("UPDATE `user` SET `online` = 1 WHERE `userId`=" + uId + " LIMIT 1;");
                    return user;
                }
                else {
                    GameCanvas.startOKDlg(session, Text.get(0, 0));
                }
            }
            finally {
                mySQL.close();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return user;
    }
    
    protected static Player Create(final Session_ME session, final String name, final byte gender, final byte hair) {
        if (session.user.numPlayer < GameScr.max_CreateChar) {
            if (!Util.CheckString(name, "^[a-zA-Z0-9]+$") || name.length() < 5 || name.length() > 15) {
                GameCanvas.startOKDlg(session, Text.get(0, 5));
                return null;
            }
            try {
                final MySQL mySQL = new MySQL(1);
                try {
                    ResultSet red = mySQL.stat.executeQuery("SELECT `playerId` FROM `player` WHERE `cName` LIKE '" + Util.strSQL(name) + "' LIMIT 1;");
                    if (red == null || !red.first() || red.getInt("playerId") <= 0) {
                        mySQL.stat.executeUpdate("INSERT INTO player(`cgender`,`head`,`cName`,`ItemBag`,`ItemBox`,`ItemBody`,`ItemMounts`) VALUES (" + gender + "," + hair + ",'" + Util.strSQL(name) + "','[]','[]','[]','[]');");
                        red = mySQL.stat.executeQuery("SELECT `playerId` FROM `player` WHERE `cName` LIKE '" + Util.strSQL(name) + "' LIMIT 1;");
                        red.first();
                        final int playerId = red.getInt("playerId");
                        red.close();
                        final Player _char = new Player(session.user);
                        _char.ASkill.add(GameScr.skillTemplates[_char.nClass].skills[0].clone());
                        final Player player = _char;
                        final Player player2 = _char;
                        final byte bagCount = 30;
                        player2.bagCount = bagCount;
                        player.ItemBag = new Item[bagCount];
                        _char.ItemBox = new Item[30];
                        _char.ItemBody = new Item[32];
                        _char.ItemMounts = new Item[5];
                        _char.playerId = playerId;
                        _char.cName = name;
                        _char.cgender = gender;
                        _char.head = hair;
                        _char.member = new Member(playerId, name, _char.nClass, _char.cLevel, _char.pointClan);
                        _char.lastTimeOnline = System.currentTimeMillis();
                        _char.cHP = _char.cMaxHP();
                        _char.cMP = _char.cMaxMP();
                        _char.isNhanban = false;
                        _char.isHuman = true;
                        return _char;
                    }
                    GameCanvas.startOKDlg(session, Text.get(0, 6));
                }
                finally {
                    mySQL.close();
                }
                return null;
            }
            catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        }
        GameCanvas.startOKDlg(session, String.format(Text.get(0, 4), GameScr.max_CreateChar));
        return null;
    }
    
    protected static void CreateNhanBan(final Player player) {
        try {
            final MySQL mySQL = new MySQL(1);
            try {
                ResultSet red = mySQL.stat.executeQuery("SELECT `playerId` FROM `clone` WHERE `cName` LIKE '" + Util.strSQL(player.cName) + "' LIMIT 1;");
                if (!red.first()) {
                    mySQL.stat.executeUpdate("INSERT INTO `clone` (`cgender`,`head`,`cName`,`ItemBody`,`ItemMounts`) VALUES (" + player.cgender + "," + player.head + ",'" + Util.strSQL(player.cName) + "','[]','[]');");
                    red = mySQL.stat.executeQuery("SELECT `playerId` FROM `clone` WHERE `cName` LIKE '" + Util.strSQL(player.cName) + "' LIMIT 1;");
                    red.first();
                }
                final int playerId = red.getInt("playerId");
                red.close();
                final Char clone = new Char(null);
                clone.ASkill.add(clone.myskill = GameScr.skillTemplates[clone.nClass].skills[0].clone());
                clone.CSkill[0] = clone.myskill.template.id;
                clone.ItemBody = new Item[32];
                final Item wp = new Item(new ItemOption[] { new ItemOption(0, Util.nextInt(10, 20)), new ItemOption(8, Util.nextInt(1, 10)) }, (short)194, 1, -1, true, (byte)0, 5);
                wp.indexUI = 1;
                wp.typeUI = 5;
                clone.ItemBody[1] = wp;
                clone.ItemMounts = new Item[5];
                clone.playerId = playerId;
                clone.cName = player.cName;
                clone.cgender = player.cgender;
                clone.head = player.head;
                clone.updateExp(GameScr.getMaxEXP(10));
                clone.member = new Member(playerId, clone.cName, clone.nClass, clone.cLevel, clone.pointClan);
                clone.cHP = clone.cMaxHP();
                clone.cMP = clone.cMaxMP();
                clone.isNhanban = true;
                clone.isHuman = false;
                player.Nhanban = clone;
                player.cloneId = clone.playerId;
            }
            finally {
                mySQL.close();
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    protected void flush() {
        synchronized (this.LOCK) {
            this.FLUSH();
        }
    }
    
    protected void FLUSH() {
        try {
            final MySQL mySQL = new MySQL(1);
            try {
                final JSONArray JPlayer = new JSONArray();
                for (byte num = 0; num < this.players.length; ++num) {
                    if (this.players[num] != null) {
                        final JSONArray potential = new JSONArray();
                        for (byte i = 0; i < this.players[num].potential.length; ++i) {
                            potential.add((Object)this.players[num].potential[i]);
                        }
                        final JSONArray vFriend = new JSONArray();
                        for (short j = 0; j < this.players[num].vFriend.size(); ++j) {
                            final JSONArray friend = new JSONArray();
                            friend.add((Object)this.players[num].vFriend.get(j).friendName);
                            friend.add((Object)this.players[num].vFriend.get(j).type);
                            vFriend.add((Object)friend);
                        }
                        final JSONArray VSkill = new JSONArray();
                        for (byte k = 0; k < this.players[num].ASkill.size(); ++k) {
                            final JSONArray skill = new JSONArray();
                            skill.add((Object)this.players[num].ASkill.get(k).template.id);
                            skill.add((Object)this.players[num].ASkill.get(k).point);
                            VSkill.add((Object)skill);
                        }
                        final JSONArray vEff = new JSONArray();
                        for (byte l = 0; l < this.players[num].aEff.size(); ++l) {
                            if (this.players[num].aEff.get(l).type > 0) {
                                final JSONArray effect = new JSONArray();
                                effect.add((Object)this.players[num].aEff.get(l).template.id);
                                effect.add((Object)this.players[num].aEff.get(l).timeStart);
                                effect.add((Object)this.players[num].aEff.get(l).timeLenght);
                                effect.add((Object)this.players[num].aEff.get(l).param);
                                effect.add((Object)this.players[num].aEff.get(l).type);
                                vEff.add((Object)effect);
                            }
                        }
                        final JSONArray KSkill = new JSONArray();
                        for (byte m = 0; m < this.players[num].KSkill.length; ++m) {
                            KSkill.add((Object)this.players[num].KSkill[m]);
                        }
                        final JSONArray OSkill = new JSONArray();
                        for (byte i2 = 0; i2 < this.players[num].OSkill.length; ++i2) {
                            OSkill.add((Object)this.players[num].OSkill[i2]);
                        }
                        final JSONArray CSkill = new JSONArray();
                        for (byte i3 = 0; i3 < this.players[num].CSkill.length; ++i3) {
                            CSkill.add((Object)this.players[num].CSkill[i3]);
                        }
                        final JSONArray bagOpen = new JSONArray();
                        for (byte i4 = 0; i4 < this.players[num].bagOpen.size(); ++i4) {
                            bagOpen.add((Object)this.players[num].bagOpen.get(i4));
                        }
                        String sql = "`cloneId`=" + this.players[num].cloneId + ",`ctaskId`=" + this.players[num].ctaskId + ",`ctaskIndex`=" + this.players[num].ctaskIndex + ",`ctaskCount`=" + this.players[num].ctaskCount + ",`cspeed`=" + this.players[num].cspeed + ",`cPk`=" + this.players[num].cPk + ",`cEXP`=" + this.players[num].cEXP + ",`cExpDown`=" + this.players[num].cExpDown + ",`cLevel`=" + this.players[num].cLevel + ",`nClass`=" + this.players[num].nClass + ",`pPoint`=" + this.players[num].pPoint + ",`refreshpPoint`=" + this.players[num].refreshpPoint + ",`potential`='" + potential.toJSONString() + "',`sPoint`=" + this.players[num].sPoint + ",`refreshsPoint`=" + this.players[num].refreshsPoint + ",`xu`=" + this.players[num].xu + ",`xuBox`=" + this.players[num].xuBox + ",`yen`=" + this.players[num].yen + ",`vFriend`='" + vFriend.toJSONString() + "',`VSkill`='" + VSkill.toJSONString() + "',`vEff`='" + vEff.toJSONString() + "',`KSkill`='" + KSkill.toJSONString() + "',`OSkill`='" + OSkill.toJSONString() + "',`CSkill`='" + CSkill.toJSONString() + "',`bagCount`=" + this.players[num].bagCount + ",`bagOpen`='" + bagOpen.toJSONString() + "'";
                        final JSONArray ItemBag = new JSONArray();
                        for (short i5 = 0; i5 < this.players[num].ItemBag.length; ++i5) {
                            if (this.players[num].ItemBag[i5] != null) {
                                ItemBag.add(JSONValue.parseWithException(this.players[num].ItemBag[i5].toString()));
                            }
                        }
                        final JSONArray ItemBox = new JSONArray();
                        for (short i6 = 0; i6 < this.players[num].ItemBox.length; ++i6) {
                            if (this.players[num].ItemBox[i6] != null) {
                                ItemBox.add(JSONValue.parseWithException(this.players[num].ItemBox[i6].toString()));
                            }
                        }
                        final JSONArray ItemBody = new JSONArray();
                        for (short i7 = 0; i7 < this.players[num].ItemBody.length; ++i7) {
                            if (this.players[num].ItemBody[i7] != null) {
                                ItemBody.add(JSONValue.parseWithException(this.players[num].ItemBody[i7].toString()));
                            }
                        }
                        final JSONArray ItemMounts = new JSONArray();
                        for (short i8 = 0; i8 < this.players[num].ItemMounts.length; ++i8) {
                            if (this.players[num].ItemMounts[i8] != null) {
                                ItemMounts.add(JSONValue.parseWithException(this.players[num].ItemMounts[i8].toString()));
                            }
                        }
                        final JSONArray LevelGift = new JSONArray();
                        for (byte i9 = 0; i9 < this.players[num].LevelGift.size(); ++i9) {
                            LevelGift.add((Object)this.players[num].LevelGift.get(i9));
                        }
                        final JSONArray ItemUseLimit = new JSONArray();
                        for (byte i10 = 0; i10 < this.players[num].ItemUseLimit.size(); ++i10) {
                            final JSONArray limit = new JSONArray();
                            limit.add((Object)this.players[num].ItemUseLimit.get(i10).id);
                            limit.add((Object)this.players[num].ItemUseLimit.get(i10).limit);
                            limit.add((Object)(int)(this.players[num].ItemUseLimit.get(i10).isDelNextDay ? 1 : 0));
                            ItemUseLimit.add((Object)limit);
                        }
                        sql = sql + ",`ItemBag`='" + ItemBag.toJSONString() + "',`ItemBox`='" + ItemBox.toJSONString() + "',`ItemBody`='" + ItemBody.toJSONString() + "',`ItemMounts`='" + ItemMounts.toJSONString() + "',`LevelGift`='" + LevelGift.toJSONString() + "',`ItemUseLimit`='" + ItemUseLimit.toJSONString() + "'";
                        final JSONArray InfoMap = new JSONArray();
                        InfoMap.add((Object)this.players[num].statusMe);
                        InfoMap.add((Object)this.players[num].mapId);
                        InfoMap.add((Object)this.players[num].mapLTDId);
                        InfoMap.add((Object)this.players[num].cx);
                        InfoMap.add((Object)this.players[num].cy);
                        sql = sql + ",`epoint`=" + this.players[num].epoint + ",`InfoMap`='" + InfoMap.toJSONString() + "',`cClanName`='" + this.players[num].cClanName + "',`pointClan`=" + this.players[num].pointClan + ",`countPB`=" + this.players[num].countPB + ",`pointPB`=" + this.players[num].pointPB + ",`timeFinishCave`=" + this.players[num].timeFinishCave + ",`countPartyPB`=" + this.players[num].countPartyPB + ",`caveId`=" + this.players[num].caveId + ",`pointChienTruong`=" + this.players[num].pointChienTruong + ",`lastTimeonline`=" + this.players[num].lastTimeOnline + "";
                        sql = sql + ",`pointNon`=" + this.players[num].pointNon + ",`pointVukhi`=" + this.players[num].pointVukhi + ",`pointAo`=" + this.players[num].pointAo + ",`pointLien`=" + this.players[num].pointLien + ",`pointGangtay`=" + this.players[num].pointGangtay + ",`pointNhan`=" + this.players[num].pointNhan + ",`pointQuan`=" + this.players[num].pointQuan + ",`pointNgocboi`=" + this.players[num].pointNgocboi + ",`pointGiay`=" + this.players[num].pointGiay + ",`pointPhu`=" + this.players[num].pointPhu;
                        final JSONArray nvDV = new JSONArray();
                        for (byte i11 = 0; i11 < this.players[num].nvDV.length; ++i11) {
                            nvDV.add((Object)this.players[num].nvDV[i11]);
                        }
                        sql = sql + ",`nvDV`='" + nvDV.toJSONString() + "'";
                        mySQL.stat.executeUpdate("UPDATE `player` SET " + sql + " WHERE `playerId`=" + this.players[num].playerId + " LIMIT 1;");
                        if (this.players[num].cloneId != -1) {
                            final Char clone = this.players[num].Nhanban;
                            final JSONArray potential2 = new JSONArray();
                            for (byte i12 = 0; i12 < clone.potential.length; ++i12) {
                                potential2.add((Object)clone.potential[i12]);
                            }
                            final JSONArray VSkill2 = new JSONArray();
                            for (byte i13 = 0; i13 < clone.ASkill.size(); ++i13) {
                                final JSONArray skill2 = new JSONArray();
                                skill2.add((Object)clone.ASkill.get(i13).template.id);
                                skill2.add((Object)clone.ASkill.get(i13).point);
                                VSkill2.add((Object)skill2);
                            }
                            final JSONArray vEff2 = new JSONArray();
                            for (byte i14 = 0; i14 < clone.aEff.size(); ++i14) {
                                if (clone.aEff.get(i14).type > 0) {
                                    final JSONArray effect2 = new JSONArray();
                                    effect2.add((Object)clone.aEff.get(i14).template.id);
                                    effect2.add((Object)clone.aEff.get(i14).timeStart);
                                    effect2.add((Object)clone.aEff.get(i14).timeLenght);
                                    effect2.add((Object)clone.aEff.get(i14).param);
                                    effect2.add((Object)clone.aEff.get(i14).type);
                                    vEff2.add((Object)effect2);
                                }
                            }
                            final JSONArray KSkill2 = new JSONArray();
                            for (byte i15 = 0; i15 < clone.KSkill.length; ++i15) {
                                KSkill2.add((Object)clone.KSkill[i15]);
                            }
                            final JSONArray OSkill2 = new JSONArray();
                            for (byte i16 = 0; i16 < clone.OSkill.length; ++i16) {
                                OSkill2.add((Object)clone.OSkill[i16]);
                            }
                            final JSONArray CSkill2 = new JSONArray();
                            for (byte i17 = 0; i17 < clone.CSkill.length; ++i17) {
                                CSkill2.add((Object)clone.CSkill[i17]);
                            }
                            String sql2 = "`cspeed`=" + clone.cspeed + ",`cEXP`=" + clone.cEXP + ",`cExpDown`=" + clone.cExpDown + ",`cLevel`=" + clone.cLevel + ",`nClass`=" + clone.nClass + ",`pPoint`=" + clone.pPoint + ",`refreshpPoint`=" + clone.refreshpPoint + ",`potential`='" + potential2.toJSONString() + "',`sPoint`=" + clone.sPoint + ",`refreshsPoint`=" + clone.refreshsPoint + ",`VSkill`='" + VSkill2.toJSONString() + "',`vEff`='" + vEff2.toJSONString() + "',`KSkill`='" + KSkill2.toJSONString() + "',`OSkill`='" + OSkill2.toJSONString() + "',`CSkill`='" + CSkill2.toJSONString() + "'";
                            final JSONArray ItemBody2 = new JSONArray();
                            for (short i18 = 0; i18 < clone.ItemBody.length; ++i18) {
                                if (clone.ItemBody[i18] != null) {
                                    ItemBody2.add(JSONValue.parseWithException(clone.ItemBody[i18].toString()));
                                }
                            }
                            final JSONArray ItemMounts2 = new JSONArray();
                            for (short i19 = 0; i19 < clone.ItemMounts.length; ++i19) {
                                if (clone.ItemMounts[i19] != null) {
                                    ItemMounts2.add(JSONValue.parseWithException(clone.ItemMounts[i19].toString()));
                                }
                            }
                            final JSONArray ItemUseLimit2 = new JSONArray();
                            for (byte i20 = 0; i20 < clone.ItemUseLimit.size(); ++i20) {
                                final JSONArray limit2 = new JSONArray();
                                limit2.add((Object)clone.ItemUseLimit.get(i20).id);
                                limit2.add((Object)clone.ItemUseLimit.get(i20).limit);
                                limit2.add((Object)(int)(clone.ItemUseLimit.get(i20).isDelNextDay ? 1 : 0));
                                ItemUseLimit2.add((Object)limit2);
                            }
                            sql2 = sql2 + ",`ItemBody`='" + ItemBody2.toJSONString() + "',`ItemMounts`='" + ItemMounts2.toJSONString() + "',`ItemUseLimit`='" + ItemUseLimit2.toJSONString() + "',`timeLive`=" + clone.timeLiveNhanban;
                            mySQL.stat.executeUpdate("UPDATE `clone` SET " + sql2 + " WHERE `playerId`=" + this.players[num].cloneId + " LIMIT 1;");
                        }
                        JPlayer.add((Object)this.players[num].playerId);
                    }
                }
                mySQL.stat.executeUpdate("UPDATE `user` SET `online`=0,`luong`=" + this.luong + ",`player`='" + JPlayer.toJSONString() + "' WHERE `userId`=" + this.userId + " LIMIT 1;");
            }
            finally {
                mySQL.close();
            }
        }
        catch (ParseException | SQLException ex2) {
            final Exception ex = null;
            final Exception e = ex;
            System.err.println("UserName=" + this.userName + " UserId=" + this.userId);
            e.printStackTrace();
        }
    }
    
    @Override
    public String toString() {
        return this.userName;
    }
    
    protected void close() {
        if (this.player != null) {
            this.player.close();
        }
        this.flush();
    }
}
