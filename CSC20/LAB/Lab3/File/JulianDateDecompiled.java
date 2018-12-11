public class JulianDate
{
  public JulianDate() {}
  
  public static int JGREG = 588829;
  
  public static int toJulian(int paramInt1, int paramInt2, int paramInt3) {
    int i = paramInt1;
    if (paramInt1 < 0) i++;
    int j = paramInt2;
    if (paramInt2 > 2) { j++;
    } else { i--;j += 13; }
    double d = Math.floor(365.25D * i) + Math.floor(30.6001D * j) + paramInt3 + 1720995.0D;
    
    if (paramInt3 + 31 * (paramInt2 + 12 * paramInt1) >= JGREG)
    {
      int k = (int)(0.01D * i);
      d += 2 - k + 0.25D * k;
    }
    return (int)Math.floor(d);
  }
}