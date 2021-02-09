package com.stir.cscu9t4practical1;

public class InputChecker
{
    private boolean isNameSafe(String nameToCheck)
    {
        return checkStringIsntEmpty(nameToCheck);
    }//isNameSafe

    private boolean isDaySafe(String dayToCheck)
    {
        return isIntSafe(dayToCheck, 1, 31);
    }

    private boolean isMonthSafe(String monthToCheck)
    {
        return isIntSafe(monthToCheck, 1, 12);
    }

    private boolean isYearSafe(String yearToCheck)
    {
        return isIntSafe(yearToCheck, 1, 9999);
    }

    private boolean isHourSafe(String hourToCheck)
    {
        return isIntSafe(hourToCheck, 0, 23);
    }

    private boolean isMinuteSafe(String minuteToCheck)
    {
        return isIntSafe(minuteToCheck, 0, 59);
    }

    private boolean isSecondSafe(String secondToCheck)
    {
        return isIntSafe(secondToCheck, 0, 59);
    }

    private boolean isDistanceSafe(String distanceToCheck) {return isStringAFloat(distanceToCheck); }

    private boolean isCyclingSurfaceTypeSafe(EnumExerciseType exerciseType, String surfaceToCheck)
    {
        if (exerciseType.equals(EnumExerciseType.Cycling))
        {
            return checkStringIsntEmpty(surfaceToCheck);
        }
        else
        {
            return true;
        }
    }

    private boolean isCyclingRouteDifficultySafe(EnumExerciseType exerciseType, String routeToCheck)
    {
        if (exerciseType.equals(EnumExerciseType.Cycling))
        {
            return checkStringIsntEmpty(routeToCheck);
        }
        else
        {
            return true;
        }
    }

    private boolean isSprintingRepetitionsSafe(EnumExerciseType exerciseType, String repsToCheck)
    {
        if (exerciseType.equals(EnumExerciseType.Running))
        {
            return checkStringIsntEmpty(repsToCheck);
        }
        else
        {
            return true;
        }
    }

    private boolean isSprintingRecoverySafe(EnumExerciseType exerciseType, String recoveryToCheck)
    {
        if (exerciseType.equals(EnumExerciseType.Running))
        {
            return checkStringIsntEmpty(recoveryToCheck);
        }
        else
        {
            return true;
        }
    }

    private boolean isSwimmingLocationSafe(EnumExerciseType exerciseType, String swimmingLocationToCheck)
    {
        if (exerciseType.equals(EnumExerciseType.Swimming))
        {
            return checkStringIsntEmpty(swimmingLocationToCheck);
        }
        else
        {
            return true;
        }
    }

    public String isDateInputSafe(String day, String month, String year)
    {
        String result = "";

        if (!isDaySafe(day))
        {
            result += "Please check that you have put a valid number in the Day field.\n";
        }

        if (!isMonthSafe(month))
        {
            result += "Please check that you have put a valid number in the Month field.\n";
        }

        if (!isYearSafe(year))
        {
            result += "Please check that you have put a valid number in the Year field.\n";
        }

        return result;
    }   //isDateInputSafe

    public String isInputSafe(EnumExerciseType exerciseType, String name, String day, String month, String year, String hours, String minutes, String seconds, String distance, String cyclingSurfaceType, String cyclingRouteDifficulty, String sprintingRepetitions, String sprintingRecovery, String swimmingLocation)
    {
        String result = "";

        if (!isNameSafe(name))
        {
            result += "Please check that you have put a valid entry in the day field.\n";
        }

        result += isDateInputSafe(day, month, year);

        if (!isHourSafe(hours))
        {
            result += "Please check that you have put a valid number in the Hours field.\n";
        }

        if (!isMinuteSafe(minutes))
        {
            result += "Please check that you have put a valid number in the Minutes field.\n";
        }

        if (!isSecondSafe(seconds))
        {
            result += "Please check that you have put a valid number in the Seconds field.\n";
        }

        if (!isDistanceSafe(distance))
        {
            result += "Please check that you have put a valid number in the Distance field.\n";
        }

        if (!isCyclingSurfaceTypeSafe(exerciseType, cyclingSurfaceType))
        {
            result += "Please check that you have put a valid number in the Surface Type field.\n";
        }

        if (!isCyclingRouteDifficultySafe(exerciseType, cyclingRouteDifficulty))
        {
            result += "Please check that you have put a valid number in the Route Difficulty field.\n";
        }

        if (!isSprintingRepetitionsSafe(exerciseType, sprintingRepetitions))
        {
            result += "Please check that you have put a valid number in the Repetitions field.\n";
        }

        if (!isSprintingRecoverySafe(exerciseType, sprintingRepetitions))
        {
            result += "Please check that you have put a valid number in the Recovery field.\n";
        }

        if (!isSwimmingLocationSafe(exerciseType, swimmingLocation))
        {
            result += "Please check that you have put a valid number in the Location field.\n";
        }

        return result;
    }   //isInputSafe

    private boolean isIntSafe(String intToCheck, int minIntValue, int maxIntValue)
    {
        boolean result;
        int intValue;

        result = isStringAllNumericalDigits(intToCheck);

        if(result)
        {
            intValue = Integer.parseInt(intToCheck);

            if (intValue > maxIntValue || intValue < minIntValue)
            {
                result = false;
            }
        }

        return result;
    }//isIntSafe

    private boolean isStringAllNumericalDigits(String isThisAnInt)
    {
        boolean result = checkStringIsntEmpty(isThisAnInt);

        if (result)     //If the given string is not empty, check it is entirely made up of numbers.
        {
            for (char c : isThisAnInt.toCharArray()) {
                if (c != '0' && c != '1' && c != '2' && c != '3' && c != '4' && c != '5' && c != '6' && c != '7' && c != '8' && c != '9') {
                    result = false;
                    break;
                }
            }
        }

        return result;
    }   //isStringAllNumericalDigits

    private boolean isStringAFloat(String isThisAFloat)
    {
        boolean result = checkStringIsntEmpty(isThisAFloat);

        if (result)     //If the given string is not empty, check it is entirely made up of numbers.
        {
            for (char c : isThisAFloat.toCharArray()) {
                if (c != '0' && c != '1' && c != '2' && c != '3' && c != '4' && c != '5' && c != '6' && c != '7' && c != '8' && c != '9' && c != '.')
                {
                    result = false;
                    break;
                }
            }
        }

        return result;
    }   //isStringAllNumericalDigits

    private boolean checkStringIsntEmpty(String stringToCheck)
    {
        boolean result = true;

        if (stringToCheck.equals(""))
        {
            result = false;
        }

        return result;
    }   //checkStringIsntEmpty
}
