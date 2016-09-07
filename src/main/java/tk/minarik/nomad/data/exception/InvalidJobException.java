package tk.minarik.nomad.data.exception;

import lombok.Data;
import lombok.Value;
import org.springframework.web.client.HttpClientErrorException;
import tk.minarik.nomad.data.Job;

/**
 * Created by darko on 7.9.2016..
 */
@Data
public class InvalidJobException extends RuntimeException{

    private final Job job;

    public InvalidJobException(Job job){
        super(String.format("Job %s in invalid", job.getId()));
        this.job = job;
    }

}
