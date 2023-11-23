import com.example.musicAppServer.music.bean.Music;
import com.example.musicAppServer.music.dao.MusicDao;
import com.example.musicAppServer.music.dao.impl.MusicDaoImpl;
import com.example.musicAppServer.music.service.MusicService;
import com.example.musicAppServer.music.service.impl.MusicServiceImpl;

import java.sql.SQLException;
import java.util.List;

public class test {
    public static void main(String[] args) throws SQLException {
        MusicDao musicDao = new MusicDaoImpl();
        List<Music> musicList = musicDao.findAll();
        for (Music music : musicList) {
            System.out.println(music);
        }
    }
}
