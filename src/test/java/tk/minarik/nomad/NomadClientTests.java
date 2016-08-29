package tk.minarik.nomad;

import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.*;

/**
 * Created by darko on 30.8.2016..
 */
public class NomadClientTests {

    private NomadClient nomadClient = new NomadClient();

    @Test
    public void testGetRegions() {
        nomadClient.getRegions();
        Collection<String> regions = nomadClient.getRegions();
        assertNotNull(regions);
        assertFalse(regions.isEmpty());
        assertEquals(1, regions.size());
    }

}
