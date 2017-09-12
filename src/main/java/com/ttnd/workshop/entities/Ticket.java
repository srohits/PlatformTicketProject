package com.ttnd.workshop.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

	@Entity
	@Table(name = "Tickettable")
	public class Ticket {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "TicketId")
		private Integer TicketId;

		@Column(name = "StationName")
		private String StationName;

		@Column(name = "TotalCost")
		private Integer TotalCost;

		@Column(name = "userName")
		private String userName;
		
		@Column(name = "state")
		private String State;
		
		@Column(name = "district")
		private String District;
		
		
		public Ticket(){
			super();
		}

		public Ticket(Integer TicketId, String StationName, Integer TotalCost, String userName, String State, String District) {
			super();
			this.TicketId = TicketId;
			this.StationName = StationName;
			this.TotalCost = TotalCost;
			this.userName = userName;
			this.State = State;
			this.District = District;
		}
		
		public Ticket(String StationName, Integer TotalCost, String userName, String State, String District) {
			super();
			this.StationName = StationName;
			this.TotalCost = TotalCost;
			this.userName = userName;
			this.State = State;
			this.District = District;
		}
		
		public String getState(){
			return State;
		}
		
		public void setState(String State){
			this.State = State;
		}

		public String getdistrict(){
			return District;
		}
		
		public void setdistrict(String District){
			this.District = District;
		}
		
		
		public Integer getTicketId() {
			return TicketId;
		}

		public void setTicketId(Integer TicketId) {
			this.TicketId = TicketId;
		}

		public String getuserName() {
			return userName;
		}

		public void setuserName(String userName) {
			this.userName = userName;
		}
		
		public Integer gettotalcost(){
			return TotalCost;
		}
		
		public void settotalcost(Integer TotalCost){
			this.TotalCost = TotalCost;
		}
		@Override
		public String toString() {
			return "User [userId=" + TicketId + ", UserName="
					+ userName + ", State=" + State+ ", District=" + District+ ", Total Cost="+ TotalCost+"]";
		}

}
