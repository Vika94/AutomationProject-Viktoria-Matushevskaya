package Task15.listResource;

import Task15.listUsers.Support;
import lombok.Data;

import java.util.List;

@Data
public class ListResource {
    public int page;
    public int per_page;
    public int total;
    public int total_pages;
    public List<Datum1> data;
    public Support support;
}
