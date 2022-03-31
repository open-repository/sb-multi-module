package io.nio.author.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Author {
	private long Id;
	private String name;
	private String email;
	private long ISBN;

}
