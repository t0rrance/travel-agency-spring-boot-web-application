package com.example.travelagency.controller.model.order;

import com.example.travelagency.controller.model.travel.AdditionalItem;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class TravelOrderRequest {
    @ApiModelProperty("Identyfikator wykupionej wycieczki")
    private Long travelId;
    @ApiModelProperty("Klient wykupujący wycieczkę")
    private ClientRequest clientOrder;
    @ApiModelProperty("Liczba wykupionych miejsc na wycieczce przez klienta.")
    private int numberOfSeats;
    @ApiModelProperty("Data podpisania zamówienia wycieczki.")
    private Date orderDate;
    @ApiModelProperty("Data płatności za zamówioną wycieczkę.")
    private Date paymentDate;
    @ApiModelProperty("Lista uczestników wycieczki")
    private List<ClientRequest> attendanceList;
    @ApiModelProperty("Lista dodatków wycieczki")
    private List<AdditionalItem> additionalOrderItemList;
}
