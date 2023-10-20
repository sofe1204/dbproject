package com.example.demo.model.Works_in;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name="works_in")
@NoArgsConstructor
@AllArgsConstructor
public class Works_in {

    @EmbeddedId
    WorksInKey worksInKey;

    String works_from;
    String works_to;

    public WorksInKey getWorksInKey() {
        return worksInKey;
    }

    public void setWorksInKey(WorksInKey worksInKey) {
        this.worksInKey = worksInKey;
    }

    public String getWorks_from() {
        return works_from;
    }

    public void setWorks_from(String works_from) {
        this.works_from = works_from;
    }

    public String getWorks_to() {
        return works_to;
    }

    public void setWorks_to(String works_to) {
        this.works_to = works_to;
    }
}
