package tk.minarik.nomad;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import tk.minarik.nomad.data.Job;
import tk.minarik.nomad.data.response.CreateJobResponse;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

/**
 * Created by darko on 30.8.2016..
 */
@Slf4j
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

    @Test
    public void testGetAllJobs(){
        Collection<Job> jobs = nomadClient.getAllJobs();
        assertNotNull(jobs);
    }

}
