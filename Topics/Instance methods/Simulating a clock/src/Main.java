
class Clock {

    final int minuteModulo = 60;

    int hours = 12;
    int minutes = 0;

    void next() {

        //convert 60 minutes to 0
        this.minutes = (this.minutes + 1) % minuteModulo;

        //handle the hours
        if (this.minutes == 0) {
            this.hours += 1;

            //convert 13 hour to 1
            if (this.hours == 13) {
                this.hours -= 12;
            }
        }

    }

}






