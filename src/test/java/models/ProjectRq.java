package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProjectRq {

    String name;
    String announcement;
    boolean show_announcement;
    Integer suite_mode;

}