�       �RMO�0�+!\ٲ��K{�C@pNU�xmX�T�G7M�w��ɑ�<?�/�g��w�����yy�d�����$Zt�u�\]��j�8��V��r./���e��W5�<�"`˙�c�}������΅��)AW*�@�����g�ţ�ǆx(t�����x�U,�O�Fc}I޷��S��HQ�4SΖ>�T��7��=Bo#uy�7�+�ޕ1콙��BL��rXk6�لg�5X%$Ns��b�#�b԰�ʤbU�m�+�&��y0����\�Zp��rM*1��:y�ߑ<4*k�����_Ν��V���X^�5�lJ>��r�9���N��\��U����llZ�  �� ���!  ��&r      VNoVNp;���VNt   &:http://beta.ads.cc/ads/?site=1&pos=29 request-method GET response-head HTTP/1.1 200 OK
Content-Type: text/html; charset=UTF-8
Cache-Control: max-age=5
P3P: CP="NOI DSP COR NID NOR"
Content-Encoding: gzip
 charset UTF-8   s                                                                                                                                                                                                                                                                                                                                                                                                      on, Inc., 51 Franklin St, Fifth
  Floor, Boston, MA 02110-1301  USA

 */

package com.mysql.fabric.xmlrpc.base;

public class MethodCall {

    protected String methodName;
    protected Params params;

    /**
     * Gets the value of the methodName property.
     */
    public String getMethodName() {
        return this.methodName;
    }

    /**
     * Sets the value of the methodName property.
     */
    public void setMethodName(String value) {
        this.methodName = value;
    }

    /**
     * Gets the value of the params property.
     */
    public Params getParams() {
        return this.params;
    }

    /**
     * Sets the value of the params property.
     */
    public void setParams(Params value) {
        this.params = value;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        sb.append("<methodCall>");
        sb.append("	<methodName>" + this.methodName + "</methodName>");
        if (this.params != null) {
            sb.append(this.params.toString());
        }
        sb.append("</methodCall>");
        return sb.toString();
    }

}
