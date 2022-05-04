package com.craig.keniprojectwebfluxcategory.document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.repository.NoRepositoryBean;

@Data
@Builder
@NoRepositoryBean
@AllArgsConstructor
@Document(collection = "category")
public class Category {
    @Id
    private String id;
    private String name;
}
