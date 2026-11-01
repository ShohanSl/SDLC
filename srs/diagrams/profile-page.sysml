package GridLounge_ProfileScreen {
    part def ProfileScreen {
        attribute title = "GridLounge — Личный кабинет";
        
        part header : Header;
        part userProfile : UserProfile;
        part loyaltyCard : LoyaltyCard;
        part activeBookings : ActiveBookings;
        part bookingHistory : BookingHistory;
        part footer : Footer;
    }

    part def Header {
        attribute logo = "GridLounge";
        attribute navigation = "Бронирование / Профиль / Выход";
    }

    part def UserProfile {
        attribute fullName = "Шохан Вячеслав Константинович";
        attribute email = "shokhan.slava@example.com";
        attribute role = "ROLE_CLIENT";
    }

    part def LoyaltyCard {
        attribute balance = "30.00 BYN";
        attribute cashbackRate = "5% кешбэк за визиты";
        attribute conversion = "1 балл = 1 BYN";
    }

    part def ActiveBookings {
        attribute currentSeat = "Место VIP-03 (Boot-Camp)";
        attribute sessionTime = "25.10.2026, 19:00 - 22:00";
        attribute pinCode = "PIN: 4821";
        attribute cancelAction = "Кнопка отмены с полным возвратом";
    }

    part def BookingHistory {
        attribute pastSessions = "Список завершенных сессий";
        attribute spentBYN = "Сумма оплаты и начисленный кешбэк";
    }

    part def Footer {
        attribute info = "Справочная информация";
    }
}