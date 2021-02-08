package com.stir.cscu9t4practical1;

public class InputChecker
{
    private EnumExerciseType exerciseType;
    public InputChecker (EnumExerciseType exerciseType)
    {
        this.exerciseType = exerciseType;
    }   //Constructor

    public boolean isNameSafe(String nameToCheck)
    {
        return checkStringIsntEmpty(nameToCheck);
    }//isNameSafe

    public boolean isDaySafe(String dayToCheck)
    {
        return isIntSafe(dayToCheck, 1, 31);
    }

    public boolean isMonthSafe(String monthToCheck)
    {
        return isIntSafe(monthToCheck, 1, 12);
    }

    public boolean isYearSafe(String yearToCheck)
    {
        return isIntSafe(yearToCheck, 1, 9999);
    }

    public boolean isHourSafe(String hourToCheck)
    {
        return isIntSafe(hourToCheck, 0, 23);
    }

    public boolean isMinuteSafe(String minuteToCheck)
    {
        return isIntSafe(minuteToCheck, 0, 59);
    }

    public boolean isSecondSafe(String secondToCheck)
    {
        return isIntSafe(secondToCheck, 0, 59);
    }

    public boolean isDistanceSafe(String distanceToCheck) {return isStringAFloat(distanceToCheck); }

    public boolean isCyclingSurfaceTypeSafe(String surfaceToCheck)
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

    public boolean isCyclingRouteDifficultySafe(String routeToCheck)
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

    public boolean isSprintingRepetitionsSafe(String repsToCheck)
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

    public boolean isSprintingRecoverySafe(String recoveryToCheck)
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

    public boolean isSwimmingLocationSafe(String swimmingLocationToCheck)
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
