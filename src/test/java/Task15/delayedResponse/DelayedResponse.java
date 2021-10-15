package Task15.delayedResponse;

import Task15.listUsers.Support;
import lombok.Data;

import java.util.List;
@Data
public class DelayedResponse {
    public int page;
    public int per_page;
    public int total;
    public int total_pages;
    public List<Data2> data;
    public Support support;
}
