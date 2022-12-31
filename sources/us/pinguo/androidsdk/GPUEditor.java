package us.pinguo.androidsdk;
/* loaded from: classes3.dex */
public final class GPUEditor {
    public static final String EFFECT_KEY = "4F521E8A6AAB77CF386A10579F976115FAB1EBC3BB3A0E513D29F9BF65D87100225F7C8E717A1EF27ADF4EAC85E0544EBDCBE9A54B16C33D8858A204E76A6301E3393354FB58B9BB8CE028FABDAB13B9DF95179B463F5CC3C6EDB3BFC4D9E350DC45473D2B5C067004912033DBF5733A72F148B11C748D9B9681E96FBB4723C8F3A1D8FFE514D7A2BCAD925D7B5295DCE9922D5E6439E1BB623B821DB2AE95BABC71CE55F39671AAE1D7440D2584280F906BCF0277755231154502B3D870A4DDFB30F06D1F316F983699A4796BB55488140968576F9D0DA48F0DFC47C97F0CE2EFF015CA9F70D1E568235EB9CD1A8658F3A1D8FFE514D7A203B496AFA7C96BF14D3F22A0388AA985DA863AC1F246709A7983C4E4591F92B1F6BB88E171A430151605A0FB56C5F8F8638EC344A7B45AB117C8DB63AFEEEC8FFB30F06D1F316F98B29A98256AFAA4D6C8D5FE122F8A2E200ECE7ABB6D8184057CFA97F5641CFA81364CDE70A7E40C6D7ECDFF08D18BA58627B096B2E443A27B025636E96E270E3158DD02F02F5FB994DE87F688E54A53BCE172D3969EBA5A64F51B3AF4130FDDF50338E9475E73B0A87CFA97F5641CFA8116E026744B6FD42A028FE0D36CD1233A9105945AD68467B4484C16F8D0AD259496A7B371A1AB1E6B10DE89CC3B60AE7C4FBC361F64D7F5971961D933D39E7BC35C648650EF57175D8B7F6E6FCC8343447CFA97F5641CFA819DBA6A37C46799D71B12BE8C1AB47CB88654D63292C98D8155219D8F755AC97FEBA2E59C0B5E9F66D0D71775279C40657CFA97F5641CFA816FF7FD1F59015A8A2355AFDFE6D7AA0BFA63B08E912F26DC55219D8F755AC97F3251A4D455AEA56CF630E9318F206CF09E93C87B24CDB74355219D8F755AC97FB807B724F8A9B084E9B998D70C71601FB807B724F8A9B084B821E6DF7DA4917F1626A5962440DFC98AF34F7BE6603D979DBA6A37C46799D7D89FB34407BE412593E63FA8820959AE568352A9E960A8D25170BC6C74D3830E4039AC56D5485A466520AFB56BE383771EC8B3140C5C10B31D6122035DD30B391C4267A4161903C4F92D3FBAAE16FD365C73C0CAC359C7BC559A24D8E09B46979E1D4344B630F999F87859DFD71A23F4339465218974AB1B1C3B9A49251599623DA3D4CD958A97087287F1AFF184EC9CECA6A2F66693E2C731AEB6EBDAC6FB402606F9586634B8236520AFB56BE383771EC8B3140C5C10B31D6122035DD30B391C4267A4161903C4F92D3FBAAE16FD36A165B0447DD3693DFFED29EE73762739F0D152669800C70627BC63FB1E54FE88D8A97CAB12FAA3264659658E4E2258758A1ED1B99E8DAB5270CEE92160E5322A55219D8F755AC97F5CA5AB02BD7BCAF151052C47A3C9B6FE60044D6584143711FFED29EE73762739F0D152669800C70627BC63FB1E54FE88E7E2584C7DA8B336F4E46B9CEA662FCF2FEA9FCD5259598EE91EB19869F13C1F7CFA97F5641CFA81025E76F571E49772B45F7F8AD86F1AE4814E1B5395090306F370F81AA8A4080B7287F1AFF184EC9CECA6A2F66693E2C75A74ED6D745324CFE889A2DAC321DBB8AC526EFDA649DA3DC7B32BF723230C2F7287F1AFF184EC9CECA6A2F66693E2C719CFC3EFC7A8D86D1F6205B895D26FEB70CEE92160E5322A55219D8F755AC97F5CA5AB02BD7BCAF141E3087AD423E7C35C9EA9A391D1170E559A24D8E09B46979E1D4344B630F999F87859DFD71A23F490EED700698413B5B3DEDD68ACF310F17CFA97F5641CFA81025E76F571E4977239D3302E3250CB984329F3E19FB56B1D6520AFB56BE383771EC8B3140C5C10B31D6122035DD30B39F8BBB60D6072AFF94D63039FE9125C2B70CEE92160E5322A55219D8F755AC97F5CA5AB02BD7BCAF1796FFDF553064215C2D80F69129B91BA47017E1CCB45910B93E63FA8820959AE568352A9E960A8D20BACE3231951529585D358FAAA1AF8F3559A24D8E09B46979E1D4344B630F999F87859DFD71A23F47ADB0144DCCB2D967DC5F75E49BFFDB2559A24D8E09B46979E1D4344B630F999F87859DFD71A23F47ADB0144DCCB2D969ABD7B1285A2FC0470CEE92160E5322A55219D8F755AC97F5CA5AB02BD7BCAF1D489A54A680CF0533A2FAA89B5980886A47D26F2030A719A8D52B473CF94E4A7C3FB578F4337F2ED664E4973B1FBF62FE8F9D3A2324950C87287F1AFF184EC9CECA6A2F66693E2C7DC140787AA6D061A77663ED5507ABFE96520AFB56BE383771EC8B3140C5C10B31D6122035DD30B39544E391B6F16DCF115622EF0B10400FC5C12BD4D11012C337CFA97F5641CFA81025E76F571E497721C71D7325D63FB4D7DC5F75E49BFFDB2559A24D8E09B46979E1D4344B630F999F87859DFD71A23F40D0C7426EDC89C82EB4AF97CE01B3C617CFA97F5641CFA81025E76F571E497721C71D7325D63FB4D4CA681D3AF967DFC559A24D8E09B46979E1D4344B630F999F87859DFD71A23F4C0210FA76FA2248577820677AFB5E6437CFA97F5641CFA81025E76F571E49772DAF903E4E759B9FB3084CF3A48BFD9996520AFB56BE383771EC8B3140C5C10B31D6122035DD30B391984388149364DDFAB076D043163437E47017E1CCB45910B93E63FA8820959AE568352A9E960A8D206FF6CF5C105B81D4A25F3F5137DE66FA3CABD31CEACDDEEF0D152669800C70627BC63FB1E54FE88E7B8CE27905B4AD94F6AB407A8AB0F1D8BEF2D69193ED565559A24D8E09B46979E1D4344B630F999F87859DFD71A23F44ED5EC782CE7DCFBBABAFEF5B0A98CB3A47D26F2030A719A8D52B473CF94E4A74B53B64E5567954DDE890440492686A2722F5E9EC1CC9643559A24D8E09B46979E1D4344B630F999F87859DFD71A23F44ED5EC782CE7DCFB2025013AB3E172DA47017E1CCB45910B93E63FA8820959AE568352A9E960A8D2D73091457CBACBF44A2A9893777B1816559A24D8E09B46979E1D4344B630F999F87859DFD71A23F44ED5EC782CE7DCFB6F8D96D52FA6A49F70CEE92160E5322A55219D8F755AC97F5CA5AB02BD7BCAF1FDAE350EF44B143CFF5776EC0AC54599D62471A6EBDE46307CFA97F5641CFA81025E76F571E49772FD88F93E9B9DD1469C8CBD59AB71CD2E330C40098A454D6BA47D26F2030A719A8D52B473CF94E4A724719D0F8B44E049A278504391B72B1711F3317D2F7693DA6520AFB56BE383771EC8B3140C5C10B31D6122035DD30B3957F36B6E1AFCD14F2949786C324EAAD1559A24D8E09B46979E1D4344B630F999F87859DFD71A23F48D726868E516A21F1CC53FBF304F9627F0D152669800C70627BC63FB1E54FE88D61423336407E245FAA71D1077CD83B970CEE92160E5322A55219D8F755AC97F5CA5AB02BD7BCAF1B9B5E50A3757BDBADAAE7BFD3F5E439FF709F6B499C523257CFA97F5641CFA81025E76F571E4977243F757B36992A71CF74523850C1668B3E308A44914705BC547017E1CCB45910B93E63FA8820959AE568352A9E960A8D2625A0E4FB8CB80F3AC7814F75A0951D66520AFB56BE383771EC8B3140C5C10B31D6122035DD30B398EB62D4197DF608C1F6A0372183B63213B34D2B13BE68616559A24D8E09B46979E1D4344B630F999F87859DFD71A23F4BC88E229090B09B9B2A58C83ECF5735AEB4AF97CE01B3C617CFA97F5641CFA81025E76F571E49772D143671E5372C82278A13B1C6706A8DD559A24D8E09B46979E1D4344B630F999F87859DFD71A23F453343FBD013E3EB5459438629D65EB5A7CFA97F5641CFA81025E76F571E49772277094ABD9CE026B00EC116A2036FCEE6C522FF593A2DB3EF0D152669800C70627BC63FB1E54FE88F2D9AAB58295F6D860DD3CDCA2D66D6BDAB6296C9DA90D007287F1AFF184EC9CECA6A2F66693E2C7BF567342557357AB3B5E0B7F081BA015D3328D29628D0F7DA3CABD31CEACDDEEF0D152669800C70627BC63FB1E54FE8810443037E01F5755CDFA00E3D63E09C651E08B17FE3F0107559A24D8E09B46979E1D4344B630F999265A36CF91BDC860381EF8138F6BB479F0D152669800C70627BC63FB1E54FE88608B6AA693C6477A70CEE92160E5322A55219D8F755AC97F0B7F4D114084319160334947156E2E49AE34E9228017CCA2735089CCF741AD57EA52A568D9B71DCA374D1381064C68EBD4202182ABC0EDBC4F178EE15B51CF92";
    public static final int LAND_MIRROR_FRONT_HORIZONTAL = 5;
    public static final int LAND_MIRROR_FRONT_NORMAL = 1;
    public static final int LAND_MIRROR_FRONT_VERTICAL = 3;
    public static final int LAND_MIRROR_HORIZONTAL = 4;
    public static final int LAND_MIRROR_NORMAL = 0;
    public static final int LAND_MIRROR_VERTICAL = 2;
    public static final int PORT_MIRROR_FRONT = 9;
    public static final int PORT_MIRROR_FRONT_VERTICAL = 8;
    public static final int PORT_MIRROR_NORMAL = 7;
    public static final int PORT_MIRROR_NORMAL_VERTICAL = 6;
    private static final String TAG = "GPUEditor";

    private GPUEditor() {
    }
}
