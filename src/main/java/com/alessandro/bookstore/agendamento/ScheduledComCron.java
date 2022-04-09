package com.alessandro.bookstore.agendamento;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledComCron {
	@Scheduled(cron = "0/5 * * * * *")
	public void executaAgendamento(){
		System.out.println("teste ok!");
		
	}

}
