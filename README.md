# 📱 Projekt: System Rezerwacji Wizyty

## 📝 Opis projektu
Aplikacja demonstracyjna na system Android, napisana w języku **Java**. Głównym celem projektu jest pokazanie umiejętności przesyłania obiektów `Intent` oraz obsługi cyklu życia aktywności przy zwracaniu wyników (`Result API`).

---

## 🛠️ Funkcje aplikacji

### 1. Ekran główny (`MainActivity`)
*   **Formularz użytkownika:**
    *   `EditText` – Imię i nazwisko pacjenta.
    *   `Spinner` – Wybór specjalizacji lekarza.
    *   `CheckBox` – Oznaczenie wizyty jako priorytetowej (Cito).
*   **Walidacja:** System sprawdza, czy pole tekstowe nie jest puste przed przejściem dalej.
*   **Logika:** Pakowanie danych do `Bundle` i wysyłka przez `Intent.putExtra()`.

### 2. Ekran podsumowania (`SummaryActivity`)
*   **Odbiór danych:** Wykorzystanie metod `getIntent().get...Extra()`.
*   **Interakcja:**
    *   🟢 **Przycisk Potwierdź**: Zwraca `RESULT_OK`.
    *   🔴 **Przycisk Anuluj**: Zwraca `RESULT_CANCELED`.

---

## 💻 Techniczne aspekty kodu

| Funkcjonalność | Zastosowanie w kodzie |
| :--- | :--- |
| **Przesyłanie danych** | `intent.putExtra(EXTRA_NAME, value)` |
| **Odbieranie wyniku** | `ActivityResultLauncher<Intent>` |
| **Zamykanie ekranu** | `finish()` |
| **Stałe** | `public static final String EXTRA_NAME` |
