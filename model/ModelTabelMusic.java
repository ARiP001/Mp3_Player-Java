
package model;

/**
 *
 * @author HP
 */

import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelTabelMusic extends AbstractTableModel{
     List<DataMusic> listMusic;

    public ModelTabelMusic(List<DataMusic> listMusic) {
        this.listMusic = listMusic;
    }

    @Override
    public int getRowCount() {
        return listMusic.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "id";
            case 1:
                return "nama";
            case 2:
                return "judul";
            case 3:
                return "artis";
            case 4:
                return "link";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch (column) {
            case 0:
                return listMusic.get(row).getId();
            case 1:
                return listMusic.get(row).getNama();
            case 2:
                return listMusic.get(row).getJudul();
            case 3:
                return listMusic.get(row).getArtis();
            case 4:
                return listMusic.get(row).getLink();
            default:
                return null;
        }
    }
}
