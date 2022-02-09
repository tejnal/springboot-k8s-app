package com.springboot.k8s.springbootk8sapp.data.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "books")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Books {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @Column(name = "title")
  private String title;

  @Column(name = "description")
  private String description;

  @Column(name = "published")
  private boolean published;

  public Books(String title, String description, boolean published) {
    this.title = title;
    this.description = description;
    this.published = published;
  }
}
