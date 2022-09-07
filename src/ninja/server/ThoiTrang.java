
package ninja.server;

public class ThoiTrang
{
    protected static final byte HAIR = 0;
    protected static final byte Body = 1;
    protected static final byte LEG = 2;
    protected static final byte WEA_PONE = 3;
    protected static final byte PP = 4;
    protected static final byte NAME = 5;
    protected static final byte HORSE = 6;
    protected static final byte RANK = 7;
    protected static final byte MAT_NA = 8;
    protected static final byte Bien_Hinh = 9;
    
    protected static void setThoiTrang(final Char _char, final short templateId) {
        switch (templateId) {
            case 795: {
                _char.setThoiTrang[0] = 37;
                _char.setThoiTrang[1] = 38;
                _char.setThoiTrang[2] = 39;
                break;
            }
            case 796: {
                _char.setThoiTrang[0] = 40;
                _char.setThoiTrang[1] = 41;
                _char.setThoiTrang[2] = 42;
                break;
            }
            case 797: {
                _char.setThoiTrang[4] = 43;
                break;
            }
            case 798: {
                _char.setThoiTrang[6] = 36;
                break;
            }
            case 799: {
                _char.setThoiTrang[3] = 44;
                break;
            }
            case 800: {
                _char.setThoiTrang[3] = 46;
                break;
            }
            case 801: {
                _char.setThoiTrang[6] = 47;
                break;
            }
            case 802: {
                _char.setThoiTrang[6] = 48;
                break;
            }
            case 803: {
                _char.setThoiTrang[6] = 49;
                break;
            }
            case 804: {
                _char.setThoiTrang[0] = 58;
                _char.setThoiTrang[1] = 59;
                _char.setThoiTrang[2] = 60;
                break;
            }
            case 805: {
                _char.setThoiTrang[0] = 55;
                _char.setThoiTrang[1] = 56;
                _char.setThoiTrang[2] = 57;
                break;
            }
            case 813: {
                _char.setThoiTrang[8] = 54;
                break;
            }
            case 814: {
                _char.setThoiTrang[8] = 53;
                break;
            }
            case 815: {
                _char.setThoiTrang[8] = 52;
                break;
            }
            case 816: {
                _char.setThoiTrang[8] = 51;
                break;
            }
            case 817: {
                _char.setThoiTrang[8] = 50;
                break;
            }
            case 825: {
                _char.setThoiTrang[5] = 61;
                break;
            }
            case 826: {
                _char.setThoiTrang[5] = 62;
                break;
            }
            case 827: {
                _char.setThoiTrang[6] = 63;
                break;
            }
            case 830: {
                _char.setThoiTrang[0] = 69;
                _char.setThoiTrang[1] = 70;
                _char.setThoiTrang[2] = 71;
                break;
            }
            case 831: {
                _char.setThoiTrang[6] = 72;
                break;
            }
        }
    }
    
    protected static void removeThoiTrang(final Char _char, final short templateId) {
        switch (templateId) {
            case 795:
            case 796: {
                _char.setThoiTrang[0] = -1;
                _char.setThoiTrang[1] = -1;
                _char.setThoiTrang[2] = -1;
                break;
            }
            case 797: {
                _char.setThoiTrang[4] = -1;
                break;
            }
            case 798: {
                _char.setThoiTrang[6] = -1;
                break;
            }
            case 799:
            case 800: {
                _char.setThoiTrang[3] = -1;
                break;
            }
            case 801:
            case 802:
            case 803: {
                _char.setThoiTrang[6] = -1;
                break;
            }
            case 804:
            case 805: {
                _char.setThoiTrang[0] = -1;
                _char.setThoiTrang[1] = -1;
                _char.setThoiTrang[2] = -1;
                break;
            }
            case 813:
            case 814:
            case 815:
            case 816:
            case 817: {
                _char.setThoiTrang[8] = -1;
                break;
            }
            case 825:
            case 826: {
                _char.setThoiTrang[5] = -1;
                break;
            }
            case 827: {
                _char.setThoiTrang[6] = -1;
                break;
            }
            case 830: {
                _char.setThoiTrang[0] = -1;
                _char.setThoiTrang[1] = -1;
                _char.setThoiTrang[2] = -1;
                break;
            }
            case 831: {
                _char.setThoiTrang[6] = -1;
                break;
            }
        }
    }
}
