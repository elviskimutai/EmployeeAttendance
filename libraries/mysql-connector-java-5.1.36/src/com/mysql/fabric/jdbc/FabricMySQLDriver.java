��� �c�   �2X                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                SQLite format 3   @                                                                     -�!� � ���                                                                                                                                                                                                                                                                                                                                                  �~!))�-t a b l e c a c h e v 3 c a c h e v 3 C R E A T E   T A B L E   c a c h e v 3   ( m d 5   C H A R ( 3 2 )   u n i q u e ,   t i m e   I N T ,   m d 5 r e s u l t   B L O B ,   n e t v e r   I N T ,   c a c h e t o   I N T ,   d u m m y   i n t ) S!u) i n d e x s q l i t e _ a u t o i n d e x _ c a c h e v 3 _ 1 c a c h e v 3 �!))�At a b l e v e r s i o n v e r s i o n C R E A T E   T A B L E   v e r s i o n   ( v e r   v a r c h a r ( 1 6 )   u n i q u e ) S!u) i n d e x s q l i t e _ a u t o i n d e x _ v e r s i o n _ 1 v e r s i o n    �2Xo                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        ing FABRIC_SERVER_GROUP_PROPERTY_KEY = "fabricServerGroup";
    public static final String FABRIC_PROTOCOL_PROPERTY_KEY = "fabricProtocol";
    public static final String FABRIC_USERNAME_PROPERTY_KEY = "fabricUsername";
    public static final String FABRIC_PASSWORD_PROPERTY_KEY = "fabricPassword";
    public static final String FABRIC_REPORT_ERRORS_PROPERTY_KEY = "fabricReportErrors";

    // Register ourselves with the DriverManager
    static {
        try {
            DriverManager.registerDriver(new FabricMySQLDriver());
        } catch (SQLException ex) {
            throw new RuntimeException("Can't register driver", ex);
        }
    }

    public FabricMySQLDriver() throws SQLException {
    }

    @Override
    public Connection connect(String url, Properties info) throws SQLException {
        Properties parsedProps = parseFabricURL(url, info);

        if (parsedProps == null) {
            return null;
        }

        parsedProps.setProperty(FABRIC_PROTOCOL_PROPERTY_KEY, "http");
        if (com.mysql.jdbc.Util.isJdbc4()) {
            try {
                Constructor<?> jdbc4proxy = Class.forName("com.mysql.fabric.jdbc.JDBC4FabricMySQLConnectionProxy").getConstructor(
                        new Class[] { Properties.class });
                return (Connection) com.mysql.jdbc.Util.handleNewInstance(jdbc4proxy, new Object[] { parsedProps }, null);
            } catch (Exception e) {
                throw (SQLException) new SQLException(e.getMessage()).initCause(e);
            }
        }

        return new FabricMySQLConnectionProxy(parsedProps);
    }

    /**
     * Determine whether this is a valid Fabric MySQL URL. It should be of the form:
     * <i>jdbc:mysql:fabric://host:port/?options</i>.
     */
    @Override
    public boolean acceptsURL(String url) throws SQLException {
        return parseFabricURL(url, null) != null;
    }

    /* static */Properties parseFabricURL(String url, Properties defaults) throws SQLException {
        if (!url.startsWith("jdbc:mysql:fabric://")) {
     ���k��U����={�  ||��=k�ǃSSS|.GQTuu��[��ݳ��'��,k6�Owt����͙3��,�)��{ƻm�֡K��o�E������9��P(�㙧�޿����~|��tGǡ�6�ސL&8N��;�&ӗZ�x�/���y�������uu���ٺ�:�e��,�8<~���~x�{�x�����^oMu�+�^�߶b����=���-?�|�}���]�~Ӧ���� �����L&�Juu��(�h;|����9��kN誔��ƪ��#G�$���.]��ɓ���V� �$���l �ҒRI�|>�]-� �[�맧�c����Vi�����z��`�9c�Z~�ys��c�����[��#6n����7�C�V�ܵ���N���e˺Ξ���m�rM}  ���(ڏI�&�y��Em�E��j��h��ϧ������Ɔ_�mmm