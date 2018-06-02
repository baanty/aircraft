/**
 * 
 */
package vo;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Pijush
 *
 */

@Getter
@Setter
public class ApiResponseVo implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 9162820914283039391L;
    
    
    private String counter;
    
    private String showableVlaue;

    /**
     * @param counter
     * @param showableVlaue
     */
    public ApiResponseVo(String counter, String showableVlaue) {
        super();
        this.counter = counter;
        this.showableVlaue = showableVlaue;
    }
    
    

}
