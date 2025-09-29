# 💵 Financial Calculators
> Workbook 1w | LC 1 Class 6
> 
> Jasmine Tu 

---

###  Interesting Code
``` java
double presentValue = monthlyPayout * (
                (1 - Math.pow(1 + annualInterestRate / 12, -12 * numYears))
                / (annualInterestRate / 12));
```
This piece of code calculates the present value of an ordinary annuity. It's interesting to me because of how the "present value" is calculated. It was also quite challenging to arrive at this formula, which required a lot of trial and error. 

I also thought the following code was interesting:
``` java
while (!choice.equalsIgnoreCase("x")) {
            finCalc.printMenu();
            choice = scnr.nextLine();

            if (choice.equals("1")) { //mortgage calc
                finCalc.mortgageCalculator(scnr);
            }
            else if (choice.equals("2")) { //cd calc
                finCalc.cdCalculator(scnr);
            }
            else if (choice.equals("3")) { //annuity calc
                finCalc.annuityCalculator(scnr);
            }
            else if (!choice.equalsIgnoreCase("x")) { //invalid choice
                System.out.println("Invalid choice. Please try again.");
            }
            //if 'x', then do nothing -> exits loop
        }
```
This is because it performs 2 things: dealing with erroneous inputs and allowing the user to stay within the program instead of exiting after using just 1 calculator.

---

## 📸 Screenshots
### ☘️ Home Screen
<img width="1512" height="982" alt="1w_home_screen" src="https://github.com/user-attachments/assets/b064be8c-9c3a-43cd-8ea1-4039ad29bc21" />

### ☘️ Calculators 1-3 (Mortgage, CD, Annuity)
**ONE.**  
<img width="563" height="380" alt="1w_calculator1" src="https://github.com/user-attachments/assets/f0a5e79a-af00-42df-bb3e-14eac723c91e" />

**TWO.**  
<img width="756" height="380" alt="1w_calculator2" src="https://github.com/user-attachments/assets/fcbf9151-38f1-4608-ae5c-2aa0b874eaad" />


**THREE.**  
<img width="778" height="389" alt="1w_calculator3" src="https://github.com/user-attachments/assets/2eb46a7c-6159-4c20-9c02-76699266c1df" />

### ☘️ End Program
<img width="584" height="242" alt="1w_exit" src="https://github.com/user-attachments/assets/c2084e07-f9c2-4075-97e7-057a5bc7b23c" />

### ☘️ Erroneous Inputs
<img width="586" height="589" alt="1w_errors" src="https://github.com/user-attachments/assets/a254a05f-7973-4d81-9c19-03df293b8145" />
