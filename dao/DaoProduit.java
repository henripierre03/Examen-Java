using gestion_commercial.dto;
using gestion_commercial.models;
using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace gestion_commercial.dao
{
    public class DaoProduit : Database, IProduitDao
    {
        public DaoProduit()
        {
            tableName = "produit";
        }package gestion_commercial.dao;
        
        import gestion_commercial.dto.ProduitDto;
        import gestion_commercial.models.Produit;
        import gestion_commercial.models.SousCategorie;
        
        import java.sql.Connection;
        import java.sql.PreparedStatement;
        import java.sql.ResultSet;
        import java.sql.SQLException;
        import java.util.ArrayList;
        import java.util.List;
        
        public class DaoProduit extends Database implements IProduitDao {
        
            private String tableName;
        
            public DaoProduit() {
                this.tableName = "produit";
            }
        
            @Override
            public int delete(int id) {
                String sql = "DELETE FROM produit WHERE id = ?";
                try (Connection conn = getConnection();
                     PreparedStatement stmt = conn.prepareStatement(sql)) {
                    stmt.setInt(1, id);
                    return stmt.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return 0;
            }
        
            @Override
            public List<Produit> findAll() {
                String sql = "SELECT p.id, p.libelle AS libelle_produit, stock, prix, reference, image, " +
                             "id_sous_categorie, c.libelle AS libelle_sous_cat, id_categorie " +
                             "FROM produit p, categorie c WHERE p.id_sous_categorie = c.id";
                List<Produit> produits = new ArrayList<>();
                try (Connection conn = getConnection();
                     PreparedStatement stmt = conn.prepareStatement(sql);
                     ResultSet rs = stmt.executeQuery()) {
        
                    while (rs.next()) {
                        // Création des objets produits et ajout à la liste
                        Produit produit = new Produit();
                        produit.setId(rs.getInt("id"));
                        produit.setLibelle(rs.getString("libelle_produit"));
                        produit.setQteStock(rs.getInt("stock"));
                        produit.setPrix(rs.getDouble("prix"));
                        produit.setReference(rs.getString("reference"));
                        produit.setImage(rs.getString("image"));
                        // Sous-categorie et autres informations à initialiser
                        SousCategorie sousCategorie = new SousCategorie();
                        sousCategorie.setId(rs.getInt("id_sous_categorie"));
                        sousCategorie.setLibelle(rs.getString("libelle_sous_cat"));
                        produit.setSousCategorie(sousCategorie);
                        produits.add(produit);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return produits;
            }
        
            @Override
            public Produit findById(int id) {
                throw new UnsupportedOperationException("Not implemented yet");
            }
        
            @Override
            public List<Produit> findProduitByReference(String reference) {
                String sql = "SELECT id, libelle, stock, prix FROM produit WHERE reference LIKE ?";
                List<Produit> produits = new ArrayList<>();
                try (Connection conn = getConnection();
                     PreparedStatement stmt = conn.prepareStatement(sql)) {
                    stmt.setString(1, "%" + reference + "%");
                    try (ResultSet rs = stmt.executeQuery()) {
                        while (rs.next()) {
                            Produit produit = new Produit();
                            produit.setId(rs.getInt("id"));
                            produit.setLibelle(rs.getString("libelle"));
                            produit.setQteStock(rs.getInt("stock"));
                            produit.setPrix(rs.getDouble("prix"));
                            produits.add(produit);
                        }
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return produits;
            }
        
            @Override
            public int insert(Produit produit) {
                String sql = "INSERT INTO produit (libelle, stock, prix, reference, id_sous_categorie, image) " +
                             "VALUES (?, ?, ?, ?, ?, ?)";
                try (Connection conn = getConnection();
                     PreparedStatement stmt = conn.prepareStatement(sql)) {
        
                    stmt.setString(1, produit.getLibelle());
                    stmt.setInt(2, produit.getQteStock());
                    stmt.setDouble(3, produit.getPrix());
                    stmt.setString(4, produit.getReference());
                    stmt.setInt(5, produit.getSousCategorie().getId());
                    stmt.setString(6, produit.getImage());
        
                    return stmt.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return 0;
            }
        
            @Override
            public int update(Produit produit) {
                String sql = "UPDATE produit SET libelle = ?, stock = ?, prix = ?, id_sous_categorie = ?, image = ? WHERE id = ?";
                try (Connection conn = getConnection();
                     PreparedStatement stmt = conn.prepareStatement(sql)) {
        
                    stmt.setString(1, produit.getLibelle());
                    stmt.setInt(2, produit.getQteStock());
                    stmt.setDouble(3, produit.getPrix());
                    stmt.setInt(4, produit.getSousCategorie().getId());
                    stmt.setString(5, produit.getImage());
                    stmt.setInt(6, produit.getId());
        
                    return stmt.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return 0;
            }
        
            @Override
            public int update(ProduitDto produit) {
                String sql = "UPDATE produit SET stock = ? WHERE id = ?";
                try (Connection conn = getConnection();
                     PreparedStatement stmt = conn.prepareStatement(sql)) {
        
                    stmt.setInt(1, produit.getQteStock());
                    stmt.setInt(2, produit.getId());
        
                    return stmt.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return 0;
            }
        }
        

        public int delete(int id)
        {
            string sql = string.Format("delete from produit where id={0} ", id);
             return executeUpdate(sql);
        }

        public DataTable findAll()
        {
            string sql = "select p.id,p.libelle as libelle_produit,stock,prix,reference,image," +
                      

import dao.Database;" id_sous_categorie,c.libelle as libelle_sous_cat,id_categorie " +
                         " from produit p,categorie c" +
                         " where p.id_sous_categorie=c.id ";
            return executeSelect(sql);
        }

        public Produit findById(int id)
        {
            throw new NotImplementedException();
        }

        public DataTable findProduitByReference(string reference)
        {
            string sql = string.Format("select id,libelle,stock,prix from produit" +
                                      " where reference like '{0}'", reference);
            return executeSelect(sql);
        }

        public int insert(Produit produit)
        {
            string sql = string.Format("insert into produit(libelle,stock,prix,reference,id_sous_categorie,image)" +
                        " values('{0}',{1},{2},'{3}',{4},@avatar)",
                        produit.Libelle, produit.QteStock,
                        produit.Prix, produit.Reference,
                        produit.SousCategorie.Id);

            return executeUpdate(sql,produit.Image);
        }

        public int update(Produit produit)
        {
            string sql = string.Format("update produit set libelle='{0}'," +
                            " stock={1},prix={2}, " +
                            " id_sous_categorie={3},image=@avatar where id={4}", 
                                produit.Libelle, produit.QteStock,
                                produit.Prix,
                                produit.SousCategorie.Id,
                                produit.Id);
            return executeUpdate(sql, produit.Image);
        }
        public int update(ProduitDto produit)
        {
            string sql = string.Format("update produit set stock={0} where id={1}",
                                produit.QteStock,produit.Id);
                            
            return executeUpdate(sql);
        }
    }
}
