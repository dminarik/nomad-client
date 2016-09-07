package tk.minarik.nomad;

import org.junit.Test;

/**
 * Created by darko on 8.9.2016..
 */
public class SystemTest {

    private NomadClient nomadClient = new NomadClient();

    @Test
    public void testGarbageCollect(){
        nomadClient.garbageCollect();
    }

    @Test
    public void testGarbageCollectWithRegion(){
        nomadClient.garbageCollect("global");
    }

    @Test
    public void testReconcileSummaries(){
        nomadClient.reconcileSummaries();
    }

    @Test
    public void testReconcileSummariesWithRegion(){
        nomadClient.reconcileSummaries("global");
    }

}
