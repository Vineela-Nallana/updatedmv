//package com.example.movieticketbooking.model;
//
//import org.springframework.data.annotation.Id;
//import org.springframework.data.annotation.Version;
//import org.springframework.data.mongodb.core.mapping.Document;
//
//import java.time.Instant;
//
//@Document(collection = "movie_tickets")
//public class MovieTicket {
//
//    @Id
//    private String id;
//
//    @Version
//    private Integer version;
//
//    private String movieName;
//    private String theatreName;
//    private String seatNumber;
//    private String paymentStatus;
//    private String bookingTimestamp;
//
//    // Getters and Setters
//
//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public Integer getVersion() {
//        return version;
//    }
//
//    public void setVersion(Integer version) {
//        this.version = version;
//    }
//
//    public String getMovieName() {
//        return movieName;
//    }
//
//    public void setMovieName(String movieName) {
//        this.movieName = movieName;
//    }
//
//    public String getTheatreName() {
//        return theatreName;
//    }
//
//    public void setTheatreName(String theatreName) {
//        this.theatreName = theatreName;
//    }
//
//    public String getSeatNumber() {
//        return seatNumber;
//    }
//
//    public void setSeatNumber(String seatNumber) {
//        this.seatNumber = seatNumber;
//    }
//
//    public String getPaymentStatus() {
//        return paymentStatus;
//    }
//
//    public void setPaymentStatus(String paymentStatus) {
//        this.paymentStatus = paymentStatus;
//    }
//
//    public String getBookingTimestamp() {
//        return bookingTimestamp;
//    }
//
//    public void setBookingTimestamp(String bookingTimestamp) {
//        this.bookingTimestamp = bookingTimestamp;
//    }
//
//    @Override
//    public String toString() {
//        return "MovieTicket{" +
//                "id='" + id + '\'' +
//                ", movieName='" + movieName + '\'' +
//                ", theatreName='" + theatreName + '\'' +
//                ", seatNumber='" + seatNumber + '\'' +
//                ", paymentStatus='" + paymentStatus + '\'' +
//                ", bookingTimestamp='" + bookingTimestamp + '\'' +
//                '}';
//    }
//}


//package com.example.movieticketbooking.model;
//
//import org.springframework.data.mongodb.core.mapping.Document;
//
//@Document(collection = "movie_tickets")
//public class MovieTicket {
//
//    private String movieName;
//    private String theatreName;
//    private String seatNumber;
//    private String paymentStatus;
//
//    // Getters and Setters
//
//    public String getMovieName() {
//        return movieName;
//    }
//
//    public void setMovieName(String movieName) {
//        this.movieName = movieName;
//    }
//
//    public String getTheatreName() {
//        return theatreName;
//    }
//
//    public void setTheatreName(String theatreName) {
//        this.theatreName = theatreName;
//    }
//
//    public String getSeatNumber() {
//        return seatNumber;
//    }
//
//    public void setSeatNumber(String seatNumber) {
//        this.seatNumber = seatNumber;
//    }
//
//    public String getPaymentStatus() {
//        return paymentStatus;
//    }
//
//    public void setPaymentStatus(String paymentStatus) {
//        this.paymentStatus = paymentStatus;
//    }
//
//    @Override
//    public String toString() {
//        return "MovieTicket{" +
//                "movieName='" + movieName + '\'' +
//                ", theatreName='" + theatreName + '\'' +
//                ", seatNumber='" + seatNumber + '\'' +
//                ", paymentStatus='" + paymentStatus + '\'' +
//                '}';
//    }
//}
