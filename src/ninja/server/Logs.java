
package ninja.server;

import java.sql.SQLException;
import java.util.Date;
import java.time.Instant;
import io.MySQL;
import org.json.simple.JSONArray;

public class Logs
{
    public static void giaodichl(final String cName, final int xuSend, final String tocName, final Item[] arrItem) {
        try {
            final JSONArray items = new JSONArray();
            for (byte i = 0; i < arrItem.length; ++i) {
                final Item item = arrItem[i];
                if (item != null) {
                    final JSONArray it = new JSONArray();
                    it.add((Object)item.template.id);
                    it.add((Object)item.quantity);
                    items.add((Object)it);
                }
            }
            final MySQL mySQL = new MySQL(1);
            mySQL.stat.executeUpdate("INSERT INTO `logs_giaodich` (`cName`, `time_format`, `time_mili`, `xuGiaoDich`, `tocName`, `Items`) VALUES ('" + Util.strSQL(cName) + "', '" + Util.toDateString(Date.from(Instant.now())) + "', '" + System.currentTimeMillis() + "', '" + xuSend + "', '" + Util.strSQL(tocName) + "', '" + items.toJSONString() + "');");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
