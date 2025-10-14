public class LicationTester {
    public static void main(String[] args) {
        
        // ===== إنشاء المواقع باستخدام Constructor مع معاملات =====
        
        // ===== استخدام OVERLOADING: Constructor مع معاملات =====
        // موقعك الحالي  - باستخدام Constructor مع معاملات
        SimpleLocation currentLocation = new SimpleLocation(32.856346,12.056328);
        
        // موقع كلية تقنية المعلومات - باستخدام Constructor مع معاملات
        SimpleLocation collegeLocation = new SimpleLocation(32.852671,12.061304);
        
        // ===== حساب المسافة باستخدام دالة distanceTo من SimpleLocation =====
        System.out.println(currentLocation.distanceTo(collegeLocation)+"km");
        
        // ===== أمثلة على Overloading =====
        
        // ===== استخدام OVERLOADING: Constructor بدون معاملات =====
        // مثال 1: Constructor بدون معاملات (يستخدم الإحداثيات الافتراضية)
        SimpleLocation defaultLocation = new SimpleLocation();
        System.out.println(defaultLocation.getLatitude()); // يجب أن يطبع 32.852671
        
        // ===== استخدام OVERLOADING: Constructor مع معاملات مختلفة =====
        // مثال 2: Constructor مع معاملات مختلفة
        SimpleLocation customLocation = new SimpleLocation(32.0, 12.0);
        System.out.println(customLocation.getLatitude()); // يجب أن يطبع 32.0
    }
}
