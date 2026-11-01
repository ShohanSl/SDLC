package GridLounge_AdminScreen {
    part def AdminScreen {
        attribute title = "GridLounge — Управление залом";
        
        part header : AdminHeader;
        part clubStats : ClubStats;
        part bookingsJournal : BookingsJournal;
        part maintenanceAction : MaintenanceAction;
        part footer : Footer;
    }

    part def AdminHeader {
        attribute logo = "GridLounge Admin";
        attribute adminName = "Дежурный администратор";
        attribute shiftDate = "Текущая смена: 25.10.2026";
    }

    part def ClubStats {
        attribute freeSeats = "Свободно 14 / 16";
        attribute awaitingPayment = "Ожидают оплаты на месте: 1";
        attribute activeGuests = "Гостей в зале: 3";
        attribute underRepair = "На ремонте (ТО): 1 (PC-08)";
    }

    part def BookingsJournal {
        attribute columns = "Время, Стол, Гость, Оплата, Статус";
        attribute checkInBtn = "Отметка явки гостя";
        attribute confirmCashBtn = "Прием оплаты на месте и кешбэк";
    }

    part def MaintenanceAction {
        attribute toggleMaintBtn = "Перевод стола в режим ТО / Снятие ТО";
        attribute lockBooking = "Мгновенная блокировка на карте";
    }

    part def Footer {
        attribute logStatus = "Смена открыта, журнал синхронизирован";
    }
}