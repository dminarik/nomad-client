package tk.minarik.nomad;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by darko on 8.9.2016..
 */
public class StatusTests {

    private NomadClient nomadClient = new NomadClient();

    @Test
    public void testGetPeers(){
        List<String> peers = nomadClient.getPeers();
        assertNotNull(peers);
        assertEquals("127.0.0.1:4647", peers.get(0));
    }

    @Test
    public void testGetPeersWithRegion(){
        List<String> peers = nomadClient.getPeers("global");
        assertNotNull(peers);
        assertEquals("127.0.0.1:4647", peers.get(0));
    }

    @Test
    public void testGetLeader(){
        String leader = nomadClient.getLeader();
        assertNotNull(leader);
        assertEquals("127.0.0.1:4647", leader);
    }

    @Test
    public void testGetLeaderWithRegion(){
        String leader = nomadClient.getLeader("global");
        assertNotNull(leader);
        assertEquals("127.0.0.1:4647", leader);
    }

}
