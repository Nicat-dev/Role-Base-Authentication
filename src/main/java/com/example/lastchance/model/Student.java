package com.example.lastchance.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name ="student")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sid;
	private String sname;
	@CreationTimestamp
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDateTime dataTime;
	private String adress;
	private String scity;
	

	
	
}
