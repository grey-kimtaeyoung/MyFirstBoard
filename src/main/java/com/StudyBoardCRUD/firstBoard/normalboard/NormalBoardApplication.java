package com.StudyBoardCRUD.firstBoard.normalboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@SpringBootApplication
public class NormalBoardApplication {

	public static void main(String[] args) {
		SpringApplication.run(NormalBoardApplication.class, args);
	}

}
