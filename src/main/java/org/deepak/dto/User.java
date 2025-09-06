package org.deepak.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    private Card card;
    UserBankAccount bankAccount;
}
