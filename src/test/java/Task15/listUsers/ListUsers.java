package Task15.listUsers;

import lombok.Data;

import java.util.List;

@Data
public class ListUsers {
    public int page;
    public int per_page;
    public int total;
    public int total_pages;
    public List<Datum> data;
    public Support support;
}
