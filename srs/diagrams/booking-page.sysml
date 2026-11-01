package GridLounge_BookingScreen {
    part def BookingScreen {
        attribute title = "GridLounge — Бронирование столов";
        
        part header : Header;
        part zoneFilters : ZoneFilters;
        part timePicker : TimePicker;
        part clubMap : ClubMap;
        part orderSummary : OrderSummary;
        part footer : Footer;
    }

    part def Header {
        attribute logo = "GridLounge";
        attribute user = "Шохан Вячеслав";
        attribute bonusBalance = "30.00 BYN";
        attribute navigation = "Бронирование / Профиль / Помощь";
    }

    part def ZoneFilters {
        attribute zones = "Standart PC, VIP Boot-Camp, PS5, VR";
        attribute selection = "Фильтрация столов на карте";
    }

    part def TimePicker {
        attribute date = "Выбор даты бронирования";
        attribute startTime = "Время начала (дискретность 30 мин)";
        attribute tariffs = "Пакеты 1ч, 3ч, Ночь / Произвольное";
    }

    part def ClubMap {
        attribute layout = "Интерактивная карта на 18 мест";
        attribute seatInfo = "Карточка характеристик CPU/GPU/Hz";
        attribute status = "Свободно / Занято / Выбран / ТО";
    }

    part def OrderSummary {
        attribute seatId = "Выбранный стол: VIP-03";
        attribute totalPrice = "Расчет стоимости сессии";
        attribute bonusDeduction = "Списание бонусов до 100%";
        attribute payOnlineBtn = "Кнопка онлайн-оплаты";
        attribute payOfflineBtn = "Кнопка оплаты на месте";
    }

    part def Footer {
        attribute info = "Правила клуба, Контакты";
        attribute support = "Поддержка: support@gridlounge.by";
    }
}