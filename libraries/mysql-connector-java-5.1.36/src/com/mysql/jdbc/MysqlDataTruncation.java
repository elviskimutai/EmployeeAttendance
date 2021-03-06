�      �QMO�0=˯�=p����Ֆ��Mvu\<m
Y
��D��t�/&��yo&3��J�ӷ${?<�F�.����}�0�8��|h�4�L(����	���	�jU�K�ߡG�� )1)3��i��C�YW4F����F��VLj��䠼`ū��Z�`r�A�L���������ڶd���O"J`s��W�]`'۔�k�N��v��}з��w����HqY�7�ق�h+j4���6��b|X�k|Ѡ�ѡѢE㋞|�%H�o1"%�b��m���i�����  � \qc      VTYVTY;�&�VZ7   =:http://cdn1.livescore.com/ads/bet365/soccer_200x200_gif.html request-method GET request-Accept-Encoding gzip, deflate response-head HTTP/1.1 200 OK
Server: nginx
Date: Wed, 30 Sep 2015 20:55:09 GMT
Content-Type: text/html
Last-Modified: Sat, 12 Sep 2015 11:32:40 GMT
Vary: Accept-Encoding
Expires: Wed, 30 Sep 2015 21:55:09 GMT
Cache-Control: max-age=3600
Content-Encoding: gzip
 charset windows-1252                                                                                                                                                                                                                                                                                                   on, Inc., 51 Franklin St, Fifth
  Floor, Boston, MA 02110-1301  USA

 */

package com.mysql.jdbc;

import java.sql.DataTruncation;

/**
 * MySQL wrapper for DataTruncation until the server can support sending all needed information.
 */
public class MysqlDataTruncation extends DataTruncation {

    static final long serialVersionUID = 3263928195256986226L;

    private String message;

    private int vendorErrorCode;

    /**
     * Creates a new MysqlDataTruncation exception/warning.
     * 
     * @param message
     *            the message from the server
     * @param index
     *            of column or parameter
     * @param parameter
     *            was a parameter?
     * @param read
     *            was truncated on read?
     * @param dataSize
     *            size requested
     * @param transferSize
     *            size actually used
     */
    public MysqlDataTruncation(String message, int index, boolean parameter, boolean read, int dataSize, int transferSize, int vendorErrorCode) {
        super(index, parameter, read, dataSize, transferSize);

        this.message = message;
        this.vendorErrorCode = vendorErrorCode;
    }

    @Override
    public int getErrorCode() {
        return this.vendorErrorCode;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Throwable#getMessage()
     */
    @Override
    public String getMessage() {
        return super.getMessage() + ": " + this.message;
    }
}
