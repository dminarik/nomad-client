package tk.minarik.nomad;

import tk.minarik.nomad.data.*;

import java.util.Collection;
import java.util.Optional;

/**
 * Nomad client can be used for accessing Nomad HTTP API
 */
public class NomadClient {

    /**
     * Default API server address used if not defined
     */
    private static final String DEFAULT_SERVER = "127.0.0.1";
    /**
     * Default port API server is listening on used if not defined
     */
    private static final int DEFAULT_PORT = 4646;

    private final String server;
    private final int port;

    /**
     * Create client that will connect to default server and port (http://localhost:4646)
     */
    public NomadClient(){
        this(DEFAULT_SERVER, DEFAULT_PORT);
    }

    /**
     * Create client that will connect to server on default port 4646
     * @param server Server IP or hostname
     */
    public NomadClient(String server){
        this(server, DEFAULT_PORT);
    }

    /**
     * Create client that will connect to server on given port
     * @param server Server IP or hostname
     * @param port Port of Nomad HTTP API
     */
    public NomadClient(String server, int port){
        this.server = server;
        this.port = port;
    }

    /**
     * Get all jobs from current region
     * @return
     */
    public Collection<Job> getAllJobs(){
        //TODO: Implement get all jobs method
        return null;
    }

    /**
     * Get all jobs from provided region
     * @param region Region name
     * @return
     */
    public Collection<Job> getAllJobs(String region){

        //TODO: Implement get all jobs with region method
        return null;
    }

    /**
     * Get single job from current region
     * @param id Job ID
     * @return
     */
    public Job getJob(String id){
        //TODO: Implement get single job method
        return null;
    }

    /**
     * Get single job from provided region
     * @param id Job ID
     * @param region Region name
     * @return
     */
    public Job getJob(String id, String region){
        //TODO: Implement get single job with region method
        return null;
    }

    /**
     * Create new job in current region
     * @param jobId Job ID
     * @param job Job definition
     * @return
     */
    public void createJob(String jobId, Job job){
        //TODO: Implement create job method
    }

    /**
     * Create new job in specified region
     * @param jobId Job ID
     * @param job Job definition
     * @param region Region name
     * @return
     */
    public void createJob(String jobId, Job job, String region){
        //TODO: Implement create job with region method
    }

    /**
     * Modify existing job in current region
     * @param jobId Job ID
     * @param job Job definition
     * @return
     */
    public void modifyJob(String jobId, Job job){
        //TODO: Implement modify job method
    }

    /**
     * Modify existing job in current region
     * @param jobId Job ID
     * @param job Job definition
     * @param region Region name
     * @return
     */
    public void modifyJob(String jobId, Job job, String region){
        //TODO: Implement modify job with region method
    }

    /**
     * Delete job in current region
     * @param jobId Job ID
     */
    public void deleteJob(String jobId){
        //TODO: Implement delete job method
    }

    /**
     * Delete job in spacified region
     * @param jobId Job ID
     * @param region Region name
     */
    public void deleteJob(String jobId, String region){
        //TODO: Implement delete job with region method
    }

    /**
     * Get allocation beloging to job in current region
     * @param jobId Job ID
     * @return
     */
    public Collection<Allocation> getAllocations(String jobId){
        //TODO: Implement get allocations method
        return null;
    }

    /**
     * Get allocation beloging to job in specified region
     * @param jobId Job ID
     * @param region Region name
     * @return
     */
    public Collection<Allocation> getAllocations(String jobId, String region){
        //TODO: Implement get allocations with region method
        return null;
    }

    /**
     * Get allocation beloging to job in current region
     * @param jobId Job ID
     * @return
     */
    public Collection<Allocation> getJobAllocations(String jobId){
        //TODO: Implement get job allocations method
        return null;
    }

    /**
     * Get allocation beloging to job in specified region
     * @param jobId Job ID
     * @param region Region name
     * @return
     */
    public Collection<Allocation> getJobAllocations(String jobId, String region){
        //TODO: Implement get job allocations with region method
        return null;
    }

    /**
     * Get evaluation belonging to job in current region
     * @param jobId Job ID
     * @return
     */
    public Collection<Evaluation> getEvaluations(String jobId){
        //TODO: Implement get evaluations method
        return null;
    }

    /**
     * Get evaluation belonging to job in specified region
     * @param jobId Job ID
     * @param region Region name
     * @return
     */
    public Collection<Evaluation> getEvaluations(String jobId, String region){
        //TODO: Implement get evaluation with region method
        return null;
    }

    /**
     * Create new evaluation for job in current region
     * @param jobId Job ID
     */
    public void createEvaluationForJob(String jobId){
        //TODO: Implement create evaluation for job method
    }

    /**
     * Create new evaluation for job in spacified region
     * @param jobId Job ID
     * @param region Region name
     */
    public void createEvaluationForJob(String jobId, String region){
        //TODO: Implement create evaluation for job with region method
    }

    /**
     * Get job summary in current region
     * @param jobId Job ID
     * @return
     */
    public JobSummary getJobSummary(String jobId){
        //TODO: Implement get job summary method
        return null;
    }

    /**
     * Get job summary in spacified region
     * @param jobId Job ID
     * @param region Region name
     * @return
     */
    public JobSummary getJobSummary(String jobId, String region){
        //TODO: Implement get job summary with region method
        return null;
    }

    /**
     * Get execution plan for job in current region
     * @param jobId Job ID
     * @return
     */
    public ExecutionPlan getExecutionPlan(String jobId){
        //TODO: Implement get execution plan method
        return null;
    }

    /**
     * Get execution plan for job in specified region
     * @param jobId Job ID
     * @param region Region name
     * @return
     */
    public ExecutionPlan getExecutionPlan(String jobId, String region){
        //TODO: Implement get execution plan with region method
        return null;
    }

    /**
     * Get all nodes in current region
     * @param prefix Filter nodes based on ID prefix
     * @return
     */
    public Collection<Node> getNodes(Optional<String> prefix){
        //TODO: Implement get nodes method
        return null;
    }

    /**
     * Get all nodes in specified region
     * @param prefix Filter nodes based on ID prefix
     * @return
     */
    public Collection<Node> getNodes(Optional<String> prefix, String region){
        //TODO: Implement get nodes with region method
        return null;
    }

    /**
     * Get single node by ID in current region
     * @param nodeId Node ID
     * @return
     */
    public Node getNode(String nodeId){
        //TODO: Implement get node method
        return null;
    }

    /**
     * Get single node by ID in specified region
     * @param nodeId Node ID
     * @param region Region name
     * @return
     */
    public Node getNode(String nodeId, String region){
        //TODO: Implement get node with region method
        return null;
    }

    /**
     * Get allocations belonging to node in current region
     * @param nodeId Node ID
     * @return
     */
    public Collection<Allocation> getNodeAllocations(String nodeId){
        //TODO: Implement get node allocations method
        return null;
    }

    /**
     * Get allocations belonging to node in spacified region
     * @param nodeId Node ID
     * @param region Region name
     * @return
     */
    public Collection<Allocation> getNodeAllocations(String nodeId, String region){
        //TODO: Implement get node allocations with region method
        return null;
    }

    /**
     * Create evaluation for node in current region
     * @param nodeId Node ID
     */
    public void createEvaluationForNode(String nodeId){
        //TODO: Implement create evaluation for node method
    }

    /**
     * Create evaluation for node in spacified region
     * @param nodeId Node ID
     * @param region Region name
     */
    public void createEvaluationForNode(String nodeId, String region){
        //TODO: Implement create evaluation for node with region method
    }

    /**
     * Toggle drain on node in current region (No more allocations will be assigned to node)
     * @param nodeId Node ID
     */
    public void drainNode(String nodeId){
        //TODO: Implement drain node method
    }

    /**
     * Toggle drain on node in spacified region (No more allocations will be assigned to node)
     * @param nodeId Node ID
     * @param region Region name
     */
    public void drainNode(String nodeId, String region){
        //TODO: Implement drain node with region method
    }

    /**
     * Get all allocations in current region
     * @return
     */
    public Collection<Allocation> getAllocations(){
        //TODO: Implement get allocations method
        return null;
    }

    /**
     * Get all allocations in specified region
     * @param region Region name
     * @return
     */
    public Collection<Allocation> getAllAllocations(String region){
        //TODO: Implement get allocations with region method
        return null;
    }

    /**
     * Get single allocation in current region
     * @param allocationId Allocation ID
     * @return
     */
    public Allocation getAllocation(String allocationId){
        //TODO: Implement get allocation method
        return null;
    }

    /**
     * Get single allocation in specified region
     * @param allocationId Allocation ID
     * @param region Region name
     * @return
     */
    public Allocation getAllocation(String allocationId, String region){
        //TODO: Implement get allocation with region method
        return null;
    }

    /**
     * Get all evaluations in current region
     * @return
     */
    public Collection<Evaluation> getEvaluations(){
        //TODO: Implement get evaluations method
        return null;
    }

    /**
     * Get all evaluations in specified region
     * @param region Region name
     * @return
     */
    public Collection<Evaluation> getAllEvaluations(String region){
        //TODO: Implement get evaluations with region method
        return null;
    }

    /**
     * Get single evaluation from current region
     * @param evaluationId Evaluation ID
     * @return
     */
    public Evaluation getEvaluation(String evaluationId){
        //TODO: Implement get evaluation method
        return null;
    }

    /**
     * Get single evaluation from spacified region
     * @param evaluationId Evaluation ID
     * @param region Region name
     * @return
     */
    public Evaluation getEvaluation(String evaluationId, String region){
        //TODO: Implement get evaluation with region method
        return null;
    }

    /**
     * Get allocations belonging to evaluation in current region
     * @param evaluationId Evaluation ID
     * @return
     */
    public Collection<Allocation> getAllocationsForEvaluation(String evaluationId){
        //TODO: Implement get allocations for evaluation method
        return null;
    }

    /**
     * Get allocations belonging to evaluation in current region
     * @param evaluationId Evaluation ID
     * @param region Region name
     * @return
     */
    public Collection<Allocation> getAllocationsForEvaluation(String evaluationId, String region){
        //TODO: Implement get allocations for evaluation with region method
        return null;
    }

    /**
     * Get current agent state
     * @return
     */
    public AgentState getAgentState(){
        //TODO: Implement get agent state method
        return null;
    }

    /**
     * Join agent to peers
     * @param addresses Peer addresses
     */
    public void joinAgent(String[] addresses){
        //TODO: Implement join agent state method
    }

    /**
     * Get agent members
     * @return
     */
    public Collection<AgentMember> getAgentMembers(){
        //TODO: Implement get agent members method
        return null;
    }

    /**
     * Force a failed gossip member into left state
     * @param node
     */
    public void forceLeaveAgentMember(String node){
        //TODO: Implement force leave member method
    }

    /**
     * Get list of agent servers
     * @return
     */
    public Collection<String> getAgentServers(){
        //TODO: Implement get agent servers method
        return null;
    }

    /**
     * Add agent server
     * @param address
     */
    public void addAgentServer(String address){
        //TODO: Implement add agent server method
    }

    //TODO: Client FS
    //TODO: Client Stats
    //TODO: Client Allocation

    /**
     * Get list of regions
     * @return
     */
    public Collection<String> getRegions(){
        //TODO: Implement get regions method
        return null;
    }

    /**
     * Get leader address in current region
     * @return
     */
    public String getLeader(){
        //TODO: Implement get leader method
        return null;
    }

    /**
     * Get leader address in specified region
     * @param region Region name
     * @return
     */
    public String getLeader(String region){
        //TODO: Implement get leader with region method
        return null;
    }

    /**
     * Get list of peers in current region
     * @return
     */
    public Collection<String> getPeers(){
        //TODO: Implement get peers method
        return null;
    }

    /**
     * Get list of peers in specified region
     * @param region Region name
     * @return
     */
    public Collection<String> getPeers(String region){
        //TODO: Implement get peers with regions method
        return null;
    }

    /**
     * Initiate garbage collect in current region
     */
    public void garbageCollect(){
        //TODO: Implement garbage collect method
    }

    /**
     * Initiate garbage collect in specified region
     * @param region Region name
     */
    public void garbageCollect(String region){
        //TODO: Implement garbage collect with region method
    }

    /**
     * Reconcile summaries in current region
     */
    public void reconcileSummaries(){
        //TODO: Implement reconcile summaries method
    }

    /**
     * Reconcile summaries in specified region
     * @param region Region name
     */
    public void reconcileSummaries(String region){
        //TODO: Implement reconcile summaries with region method
    }

}
