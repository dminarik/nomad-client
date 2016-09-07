package tk.minarik.nomad;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import tk.minarik.nomad.data.Job;
import tk.minarik.nomad.data.Resources;
import tk.minarik.nomad.data.Task;
import tk.minarik.nomad.data.TaskGroup;
import tk.minarik.nomad.data.docker.DockerTask;
import tk.minarik.nomad.data.request.CreateJobRequest;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by darko on 6.9.2016..
 */
@Slf4j
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DockerTaskTests {

    private NomadClient nomadClient = new NomadClient();
    private ObjectMapper objectMapper = new ObjectMapper();

    @Before
    public void init(){
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    @Test
    public void test001_createDockerTask(){
        Job job = new Job("TestJobId", "TestJobName", Arrays.asList("dc1"));

        TaskGroup helloWorldTaskGroup = new TaskGroup("helloWorld");
        job.getTaskGroups().add(helloWorldTaskGroup);

        Resources resources = new Resources();
        DockerTask helloWorldTask = new DockerTask("helloWorld", "hello-world", resources);
        helloWorldTaskGroup.getTasks().add(helloWorldTask);

        nomadClient.createJob(job);
    }

    @Test
    public void test002_getDockerTask(){
        Job job = nomadClient.getJob("TestJobId");
        assertNotNull(job);
        assertEquals(job.getName(), "TestJobName");
        assertEquals(job.getTaskGroups().get(0).getName(), "helloWorld");
        assertEquals(job.getTaskGroups().get(0).getTasks().get(0).getName(), "helloWorld");
    }

    @Test
    public void test003_modifyDockerTask() throws Exception{
        Job job = new Job("TestJobId", "TestJobName2", Arrays.asList("dc1"));

        TaskGroup helloWorldTaskGroup = new TaskGroup("helloWorld2");
        job.getTaskGroups().add(helloWorldTaskGroup);

        Resources resources = new Resources();
        DockerTask helloWorldTask = new DockerTask("helloWorld2", "hello-world2", resources);
        helloWorldTaskGroup.getTasks().add(helloWorldTask);

        nomadClient.modifyJob(job);

        Job confirmJob = nomadClient.getJob("TestJobId");
        assertNotNull(confirmJob);
        assertEquals(confirmJob.getName(), "TestJobName2");
        assertEquals(confirmJob.getTaskGroups().get(0).getName(), "helloWorld2");
        assertEquals(confirmJob.getTaskGroups().get(0).getTasks().get(0).getName(), "helloWorld2");
    }

    @Test
    public void test004_deleteDockerTask() throws Exception{
        Job job = new Job("TestJobId", "TestJobName", Arrays.asList("dc1"));

        TaskGroup helloWorldTaskGroup = new TaskGroup("helloWorld");
        job.getTaskGroups().add(helloWorldTaskGroup);

        Resources resources = new Resources();
        DockerTask helloWorldTask = new DockerTask("helloWorld", "hello-world", resources);
        helloWorldTaskGroup.getTasks().add(helloWorldTask);

        nomadClient.createJob(job);

        Job confirmJob1 = nomadClient.getJob("TestJobId");
        assertNotNull(confirmJob1);

        nomadClient.deleteJob("TestJobId");

        Job confirmJob2 = nomadClient.getJob("TestJobId");
        assertNull(confirmJob2);
    }

}
