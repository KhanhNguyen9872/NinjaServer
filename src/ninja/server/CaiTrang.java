package ninja.server;

public class CaiTrang
{
    protected static short Head(final short part) {
        switch (part) {
            case 185: {
                return 185;
            }
            case 205: {
                return 205;
            }
            case 258: {
                return 258;
            }
            case 264: {
                return 264;
            }
            case 270: {
                return 270;
            }
            case 276: {
                return 276;
            }
            default: {
                return -1;
            }
        }
    }
    
    protected static short Weapon(final short part) {
        return -1;
    }
    
    protected static short Body(final short part) {
        switch (part) {
            case 185: {
                return 186;
            }
            case 205: {
                return 201;
            }
            case 258: {
                return 259;
            }
            case 264: {
                return 265;
            }
            case 270: {
                return 271;
            }
            case 276: {
                return 277;
            }
            default: {
                return -1;
            }
        }
    }
    
    protected static short Leg(final short part) {
        switch (part) {
            case 185: {
                return 187;
            }
            case 205: {
                return 207;
            }
            case 258: {
                return 260;
            }
            case 264: {
                return 266;
            }
            case 270: {
                return 272;
            }
            case 276: {
                return 278;
            }
            default: {
                return -1;
            }
        }
    }
}
