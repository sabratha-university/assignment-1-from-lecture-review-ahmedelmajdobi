public class SimpleLocation {
    // ===== المتغيرات (Fields) =====
    
    /**
     * خط العرض (Latitude) - الإحداثي الشمالي/الجنوبي
     * - القيم الموجبة: شمال خط الاستواء
     * - القيم السالبة: جنوب خط الاستواء
     * - النطاق: -90 إلى +90
     */
    private double latitude;
    
    /**
     * خط الطول (Longitude) - الإحداثي الشرقي/الغربي
     * - القيم الموجبة: شرق خط الطول الرئيسي
     * - القيم السالبة: غرب خط الطول الرئيسي
     * - النطاق: -180 إلى +180
     */
    private double longitude;
    
    // ===== Constructors (البناؤون) - مثال على Overloading =====
    
    /**
     * Constructor افتراضي بدون معاملات
     * يضع إحداثيات افتراضية (موقع كلية تقنية المعلومات)
     * 
     * هذا مثال على Overloading - نفس اسم الدالة مع معاملات مختلفة
     */
    // ===== OVERLOADING: Constructor بدون معاملات =====
    public SimpleLocation() {
        // إحداثيات كلية تقنية المعلومات
        this.latitude = 32.852671;  // خط العرض
        this.longitude = 12.061304; // خط الطول
    }
    
    /**
     * Constructor مع معاملات
     * يسمح بتحديد الإحداثيات عند إنشاء الكائن
     * 
     * هذا مثال على Overloading - نفس اسم الدالة مع معاملات مختلفة
     * 
     * @param lat خط العرض
     * @param lon خط الطول
     */
    // ===== OVERLOADING: Constructor مع معاملات =====
    public SimpleLocation(double lat, double lon) {
        this.latitude = lat;
        this.longitude = lon;
    }
    
    // ===== Getters (دوال الحصول على القيم) =====
    
    /**
     * دالة للحصول على خط العرض
     * 
     * @return قيمة خط العرض
     */
    public double getLatitude() {
        return this.latitude;
    }
    
    /**
     * دالة للحصول على خط الطول
     * 
     * @return قيمة خط الطول
     */
    public double getLongitude() {
        return this.longitude;
    }
    
    // ===== Setters (دوال تعديل القيم) =====
    
    /**
     * دالة لتعديل خط العرض
     * 
     * @param lat القيمة الجديدة لخط العرض
     */
    public void setLatitude(double lat) {
        this.latitude = lat;
    }
    
    /**
     * دالة لتعديل خط الطول
     * 
     * @param lon القيمة الجديدة لخط الطول
     */
    public void setLongitude(double lon) {
        this.longitude = lon;
    }
    
    // ===== دالة حساب المسافة =====
    
    /**
     * دالة لحساب المسافة بين موقعين باستخدام صيغة Haversine
     * 
     * @param other الموقع الآخر لحساب المسافة إليه
     * @return المسافة بالكيلومتر
     */
    public double distanceTo(SimpleLocation other) {
        return calculateDistance(this.latitude, this.longitude, 
                                other.latitude, other.longitude);
    }
    
    /**
     * دالة مساعدة لحساب المسافة بين نقطتين جغرافيتين
     * تستخدم صيغة Haversine لحساب المسافة على سطح الكرة الأرضية
     * 
     * @param lat1 خط العرض للنقطة الأولى
     * @param lon1 خط الطول للنقطة الأولى
     * @param lat2 خط العرض للنقطة الثانية
     * @param lon2 خط الطول للنقطة الثانية
     * @return المسافة بالكيلومتر
     */
    private double calculateDistance(double lat1, double lon1, 
                                   double lat2, double lon2) {
        
        // نصف قطر الأرض بالكيلومتر
        final double EARTH_RADIUS = 6371.0;
        
        // تحويل الدرجات إلى الراديان
        double lat1Rad = Math.toRadians(lat1);
        double lon1Rad = Math.toRadians(lon1);
        double lat2Rad = Math.toRadians(lat2);
        double lon2Rad = Math.toRadians(lon2);
        
        // حساب الفروق
        double deltaLat = lat2Rad - lat1Rad;
        double deltaLon = lon2Rad - lon1Rad;
        
        // صيغة Haversine
        double a = Math.sin(deltaLat / 2) * Math.sin(deltaLat / 2) +
                   Math.cos(lat1Rad) * Math.cos(lat2Rad) *
                   Math.sin(deltaLon / 2) * Math.sin(deltaLon / 2);
        
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        
        // حساب المسافة النهائية
        double distance = EARTH_RADIUS * c;
        
        return distance;
    }
    
    /**
     * دالة لعرض معلومات الموقع
     * 
     * @return نص يحتوي على الإحداثيات
     */
    // ===== OVERRIDE: إعادة تعريف toString() من Object =====
    @Override
    public String toString() {
        return String.format("الموقع: خط العرض %.4f°, خط الطول %.4f°", 
                           this.latitude, this.longitude);
    }

}
