�      �QMO�0�ﯨ=�&e�e�`t�U���Ӧ��@JM��K���bb��f23���"}K���#j��3u��9�G+4ր(-<Q	Z��j��.C���[�A����Ѓ�{P�ڔF�4K����ƨQPq�h=�Q��I
��w��j�Vh��b�4S�8�r�4~n⥶-��>�I$C	|�>xa�^ߒd�rw�t��#{s�k�{}�.FZ�ڼ��q�ZY�I�ӵ�s������`+� +àE��g9��JP_aD#F�ſ�g���7�OQ�  ���O)A           VNp;���V\�   <:http://cdn1.livescore.com/ads/bet365/soccer_468x60_gif.html request-method GET request-Accept-Encoding gzip, deflate response-head HTTP/1.1 200 OK
Server: nginx
Date: Wed, 30 Sep 2015 21:04:54 GMT
Content-Type: text/html
Last-Modified: Sat, 12 Sep 2015 11:31:30 GMT
Vary: Accept-Encoding
Expires: Wed, 30 Sep 2015 22:04:54 GMT
Cache-Control: max-age=3600
Content-Encoding: gzip
 charset windows-1252                                                                                                                                                                                                                                                                                                       on, Inc., 51 Franklin St, Fifth
  Floor, Boston, MA 02110-1301  USA

 */

package com.mysql.fabric.xmlrpc.base;

public class MethodResponse {

    protected Params params;
    protected Fault fault;

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

    /**
     * Gets the value of the fault property.
     */
    public Fault getFault() {
        return this.fault;
    }

    /**
     * Sets the value of the fault property.
     */
    public void setFault(Fault value) {
        this.fault = value;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        sb.append("<methodResponse>");
        if (this.params != null) {
            sb.append(this.params.toString());
        }
        if (this.fault != null) {
            sb.append(this.fault.toString());
        }
        sb.append("</methodResponse>");
        return sb.toString();
    }

}
